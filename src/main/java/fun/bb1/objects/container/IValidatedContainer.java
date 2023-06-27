package fun.bb1.objects.container;

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
 * A {@link Container} that clears itself when it's contents are no longer valid
 * 
 * @author BradBot_1
 */
public sealed interface IValidatedContainer extends IContainer permits ValidatedContainer<Object> {
	/**
	 * Manually forces the containers state to be checked
	 */
	public void performManagement();
	
}