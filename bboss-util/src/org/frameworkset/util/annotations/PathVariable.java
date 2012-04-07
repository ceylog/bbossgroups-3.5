/*
 *  Copyright 2008 biaoping.yin
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.frameworkset.util.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Title: PathVariable.java</p> 
 * <p>Description: </p>
 * <p>bboss workgroup</p>
 * <p>Copyright (c) 2008</p>
 * @Date 2010-10-24
 * @author biaoping.yin
 * @version 1.0
 */
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PathVariable {
	String value() default "";
	String editor() default "";
	String defaultvalue() default ValueConstants.DEFAULT_NONE;
	/**
	 * �����ַ���
	 * @return
	 */
	String decodeCharset() default ValueConstants.DEFAULT_NONE;
	
	/**
	 * ����ԭʼ�ַ���
	 * @return
	 */
	String charset() default ValueConstants.DEFAULT_NONE;
	
	/**
	 * ����ת���ַ���
	 * @return
	 */
	String convertcharset() default ValueConstants.DEFAULT_NONE;
	/**
	 * ָ�����ڸ�ʽ
	 * @return
	 */
	String dateformat() default ValueConstants.DEFAULT_NONE;

}