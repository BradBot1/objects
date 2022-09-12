package fun.bb1.objects.defineables;

import org.jetbrains.annotations.NotNull;

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
 * Declares a class as deconstructable, meaning it can be broken down into core elements
 * 
 * @apiNote This is to be used mainly by data classes and records, where an object can be broken down into simpler objects
 *  
 * @author BradBot_1
 */
public interface IDeconstructable {
	/**
	 * @return The objects as a collection of objects
	 */
	public @NotNull Object[] deconstruct();
	
}
