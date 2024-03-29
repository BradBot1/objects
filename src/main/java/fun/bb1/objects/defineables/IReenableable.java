package fun.bb1.objects.defineables;

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
 * Declares a {@link ICancellable} as re-enableable, meaning it can be enabled after being cancelled
 * 
 * @author BradBot_1
 */
public interface IReenableable extends ICancellable {
	/**
	 * Re-enable the cancelled object
	 */
	public void reenable();
}
