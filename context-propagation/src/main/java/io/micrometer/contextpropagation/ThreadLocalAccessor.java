/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micrometer.contextpropagation;

import java.util.ServiceLoader;

/**
 * Contract to assist with extracting and restoring ThreadLocal values to and
 * from a {@link ContextContainer}. To register your own {@link ThreadLocalAccessor}
 * you have to register it using the {@link ServiceLoader} mechanism.
 *
 * @since 1.0.0
 */
public interface ThreadLocalAccessor {

    /**
     * Capture ThreadLocal values and add them to the given container, so they
     * can be saved and subsequently {@link #restoreValues(ContextContainer)
     * restored} on a different thread.
     */
    void captureValues(ContextContainer container);

    /**
     * Restore ThreadLocal values from the given container.
     */
    void restoreValues(ContextContainer container);

    /**
     * Reset ThreadLocal values holders.
     */
    void resetValues(ContextContainer container);

}
