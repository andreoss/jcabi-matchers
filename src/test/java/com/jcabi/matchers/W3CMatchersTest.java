/**
 * Copyright (c) 2011-2017, jcabi.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jcabi.matchers;

import com.jcabi.aspects.RetryOnFailure;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Test case for {@link W3CMatchers}.
 * @author Carlos Miranda (miranda.cma@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class W3CMatchersTest {

    /**
     * W3CMatchers can check HTML document validity.
     */
    @Test
    @RetryOnFailure(verbose = false)
    public void matchesValidHtml() {
        MatcherAssert.assertThat(
            StringUtils.join(
                "<!DOCTYPE html>",
                "<html><head><meta charset='UTF-8'/>",
                "<title>hey</title></head>",
                "<body></body></html>"
            ),
            W3CMatchers.validHtml()
        );
    }

    /**
     * W3CMatchers can reject invalid HTML document.
     */
    @Test
    @RetryOnFailure(verbose = false)
    public void rejectsInvalidHtml() {
        MatcherAssert.assertThat(
            "<blah><blaaaaaaaaa/>",
            Matchers.not(W3CMatchers.validHtml())
        );
    }

    /**
     * W3CMatchers can check CSS document validity.
     */
    @Test
    @RetryOnFailure(verbose = false)
    public void matchesValidCss() {
        MatcherAssert.assertThat(
            "body { background-color:#d0e4fe; }",
            W3CMatchers.validCss()
        );
    }

    /**
     * W3CMatchers can reject invalid CSS document.
     */
    @Test
    @RetryOnFailure(verbose = false)
    public void rejectsInvalidCss() {
        MatcherAssert.assertThat(
            "hello { $#^@*&^$&@; }",
            Matchers.not(W3CMatchers.validCss())
        );
    }
}
