package fun.bb1.objects.annotations;

import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;

/**
 * 
 * Copyright 2022 BradBot_1
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Denotes something as legacy
 * <br>
 * An alternative to {@link Deprecated}, to be used when something will be maintained but it not the preferred way to do something
 * 
 * @author BradBot_1
 */
@Retention(CLASS)
public @interface Legacy {
	/**
	 * @return If this annotation will be replaced by {@link Deprecated} in the future
	 */
	public boolean toBeDepricated() default false;
	/**
	 * @return The version that the annotated element became legacy
	 */
	public String since() default "";
	/**
	 * @return An alternative to the legacy element
	 */
	public String alternative() default "";
	
}
