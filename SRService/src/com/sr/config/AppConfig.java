package com.sr.config;

import static com.netflix.config.ConfigurationManager.isConfigurationInstalled;
import static java.lang.String.format;
import static org.joda.time.Minutes.minutes;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.netflix.config.ConcurrentCompositeConfiguration;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicConfiguration;
import com.netflix.config.DynamicIntProperty;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import com.netflix.config.FixedDelayPollingScheduler;
import com.netflix.config.PolledConfigurationSource;
import com.netflix.config.jmx.ConfigJMXManager;
import com.netflix.config.sources.JDBCConfigurationSource;

@Component
public class AppConfig {

    protected static final String JDBC_CONFIGURATION_QUERY = "select distinct property_key, property_value from system_properties";
    protected static final String KEY_COLUMN_NAME = "property_key";
    protected static final String VALUE_COLUMN_NAME = "property_value";
    protected static final String JDBC_CONFIG_NAME = "jdbcConfig";
    private static final int POLL_INTERVAL_IN_MINUTES = 10;
    private static final int TIMEOUT_DEFAULT = 500;
    private static final String PATH_TO_SERVICE_PROPERTIES = "/resources/modelValues.properties";
    private static final Logger LOGGER = Logger.getLogger(AppConfig.class);
    private DataSource dataSource;

    @Autowired
    @Qualifier("srDataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        installJdbcSource();
    }

    public String getString(String key, String defaultValue) {
        final DynamicStringProperty property =
            DynamicPropertyFactory.getInstance().getStringProperty(key, defaultValue);
        return property.get();
    }

    public int getInt(String key, int defaultValue) {
        final DynamicIntProperty property = DynamicPropertyFactory.getInstance().getIntProperty(key, defaultValue);
        return property.get();
    }

    /*
     * This method is used by different tests to override a specific property value
     * Since the Archaius configuration is the same for all tests (one by VM)
     * you should always call the clearOverrideProperty at the end of your test
     * if you use this method so that other tests are not affected
     */
    public void setOverrideProperty(String key, Object value) {
        ((ConcurrentCompositeConfiguration) ConfigurationManager.getConfigInstance())
            .setOverrideProperty(key, value);
    }

    public void clearOverrideProperty(String key) {
        ((ConcurrentCompositeConfiguration) ConfigurationManager.getConfigInstance()).clearOverrideProperty(key);
    }

    private void installJdbcSource() {
        if (isConfigurationInstalled()) {
            return;
        }

        Properties properties = loadServiceProperties();
        ConfigurationManager.loadProperties(properties);

        ConcurrentCompositeConfiguration compositeConfiguration = createConfiguration();

        ConfigurationManager.install(compositeConfiguration);

        try {
            ConfigJMXManager.registerConfigMbean(compositeConfiguration);
        } catch (RuntimeException e) {
            LOGGER.warn(format("Failed to register Archaius Mbean %s", properties), e);
        }
    }

    private ConcurrentCompositeConfiguration createConfiguration() {
        int pollIntervalInMillis = getPollIntervalInMilliseconds();
        ConcurrentCompositeConfiguration compositeConfiguration = new ConcurrentCompositeConfiguration();

        PolledConfigurationSource source =
            new JDBCConfigurationSource(dataSource, JDBC_CONFIGURATION_QUERY, KEY_COLUMN_NAME, VALUE_COLUMN_NAME);
        DynamicConfiguration configuration =
            new DynamicConfiguration(source, new FixedDelayPollingScheduler(0, pollIntervalInMillis, false));

        compositeConfiguration.addConfiguration(configuration, JDBC_CONFIG_NAME);
        return compositeConfiguration;
    }

    private Properties loadServiceProperties() {
        Properties properties;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(PATH_TO_SERVICE_PROPERTIES);
            properties = new Properties();
            properties.load(inputStream);
        } catch (Exception exception) {
            throw new IllegalStateException("It was not possible to load " + PATH_TO_SERVICE_PROPERTIES, exception);
        }
        return properties;
    }

    private int getPollIntervalInMilliseconds() {
        int pollIntervalInMinutes = getInt("archaius.jdbc.poll.interval.minutes", POLL_INTERVAL_IN_MINUTES);
        return (int) minutes(pollIntervalInMinutes).toStandardDuration().getMillis();
    }

    public String getInventoryAlignmentHost() {
        return this.getString("inventory.alignment.host", "");
    }

    public Integer getInventoryAlignmentWebServiceTimeoutInMillis() {
        return this.getInt("inventory.alignment.webservice.timeout.in.millis", TIMEOUT_DEFAULT);
    }
}
