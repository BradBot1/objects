package fun.bb1.objects.exceptions;

import org.jetbrains.annotations.NotNull;

import fun.bb1.objects.defineables.IBuilder;

/**
 * 
 * Copyright 2023 BradBot_1
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
 * Called when an already built {@link IBuilder} has it's build method called again
 * 
 * @author BradBot_1
 */
public class BuilderBulitException extends RuntimeException {

	private static final long serialVersionUID = 8876084164174568052L;
		
	public BuilderBulitException(@NotNull final String message) {
		super(message);
	}
	
}
