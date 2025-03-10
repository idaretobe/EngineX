package com.baoying.enginex.executor.util.jeval.function.math;

import com.baoying.enginex.executor.util.jeval.EvaluationConstants;
import com.baoying.enginex.executor.util.jeval.Evaluator;
import com.baoying.enginex.executor.util.jeval.function.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 获取多个值最小值
 * @author sunyk
 *
 */
public class Min implements Function {
	
	@Override
	public FunctionResult execute(Evaluator evaluator, String arguments)
			throws FunctionException {
		Double result = null;

		ArrayList numbers = FunctionHelper.getDoubles(arguments,
				EvaluationConstants.FUNCTION_ARGUMENT_SEPARATOR);

		int count = numbers.size() ;
		if (count < 2) {
			throw new FunctionException("Two numeric arguments are required at least.");
		}

		result = (Double)Collections.min(numbers);

		return new FunctionResult(result.toString(), 
				FunctionConstants.FUNCTION_RESULT_TYPE_NUMERIC);
	}

	@Override
	public String getName() {
		return "min";
	}
}
