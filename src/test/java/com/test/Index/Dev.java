package com.test.Index;

import com.index.dev.StringCompressor;
import org.junit.Assert;
import org.junit.Test;

public class Dev {


    @Test
    public void test() {
        String compressedStr = StringCompressor.compress("aabcccccaaa");
        Assert.assertEquals("a2b1c5a3", compressedStr);
    }


}
