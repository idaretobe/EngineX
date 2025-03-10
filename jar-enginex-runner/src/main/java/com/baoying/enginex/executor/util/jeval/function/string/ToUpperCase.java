/*
 * Copyright 2002-2007 Robert Breidecker.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.baoying.enginex.executor.util.jeval.function.string;

import com.baoying.enginex.executor.util.jeval.Evaluator;
import com.baoying.enginex.executor.util.jeval.function.*;

/**
 * This class is a function that executes within Evaluator. The function returns
 * the source string in upper case. See the String.toUpperCase() method in the
 * JDK for a complete description of how this function works.
 */
public class ToUpperCase implements Function {
	/**
	 * Returns the name of the function - "toUpperCase".
	 * 
	 * @return The name of this function class.
	 */
	public String getName() {
		return "toUpperCase";
	}

	/**
	 * Executes the function for the specified argument. This method is called
	 * internally by Evaluator.
	 * 
	 * @param evaluator
	 *            An instance of Evaluator.
	 * @param arguments
	 *            A string argument that will be converted into one string
	 *            argument. The string argument(s) HAS to be enclosed in quotes.
	 *            White space that is not enclosed within quotes will be
	 *            trimmed. Quote characters in the first and last positions of
	 *            any string argument (after being trimmed) will be removed
	 *            also. The quote characters used must be the same as the quote
	 *            characters used by the current instance of Evaluator. If there
	 *            are multiple arguments, they must be separated by a comma
	 *            (",").
	 * 
	 * @return The source string, converted to lowercase.
	 * 
	 * @exception FunctionException
	 *                Thrown if the argument(s) are not valid for this function.
	 */
	public FunctionResult execute(final Evaluator evaluator, final String arguments)
			throws FunctionException {
		String result = null;
		String exceptionMessage = "One string argument is required.";

		try {
			String stringValue = arguments;

			String argumentOne = FunctionHelper.trimAndRemoveQuoteChars(
					stringValue, evaluator.getQuoteCharacter());

			result = argumentOne.toUpperCase();
		} catch (FunctionException fe) {
			throw new FunctionException(fe.getMessage(), fe);
		} catch (Exception e) {
			throw new FunctionException(exceptionMessage, e);
		}

		return new FunctionResult(result, 
				FunctionConstants.FUNCTION_RESULT_TYPE_STRING);
	}
}