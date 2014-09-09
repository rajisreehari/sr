package com.sr;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class UtilTest {
	
	@Test
	public void shouldSplitStringAccordingToParam(){
		String original = "The modal plugin toggles your hidden content on demand, via data attributes or JavaScript. "
				+ "It also adds .modal-open to the <body> to override default scrolling behavior and generates a .modal-backdrop "
				+ "to provide a click area for dismissing shown modals when clicking outside the modal.";
		List<String> output = Util.breakupString(original, 20);
		Assert.assertNotNull(output);
		Assert.assertEquals(17, output.size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowIllegalArgIfPharseExceedsAllowedSize(){
		String original = "222";
		Util.breakupString(original, 2);
	}
}
