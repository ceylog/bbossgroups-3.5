/**
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
package com.frameworkset.common.tag.pager.tags;

import java.io.OutputStream;

import javax.servlet.jsp.JspException;


/**
 * <p>BeanParamsTag.java</p>
 * <p> Description: ��bean�е�����ֵ��Ϊ��������
 * Ŀǰ֧�ּ��������ͣ��������͵�ת��
 * </p>
 * <p> bboss workgroup </p>
 * <p> Copyright (c) 2009 </p>
 * 
 * @Date 2011-11-17
 * @author biaoping.yin
 * @version 1.0
 */
public class BeanParamsTag extends PagerTagSupport {

	private String name  = null;
	/**
	 * ��������������������
	 */
	private int encodecount = 1;
	

    public int getEncodecount() {
		return encodecount;
	}

	public void setEncodecount(int encodecount) {
		this.encodecount = encodecount;
	}

	private boolean encode = false;
    public void setEncode(boolean encode)
  {
      this.encode = encode;
  }

  public boolean getEncode()
  {
      return this.encode;
  }


	

	public final void setName(String val) {
		name = val;
	}

	public final String getName() {
		return name;
	}

	
	
	public int doEndTag()throws JspException 
	{
		
		this.encode = false;
		this.name = null;
		encodecount = 1;
		return super.doEndTag();
	}

	public int doStartTag() throws JspException {
		super.doStartTag();
		if(pagerContext != null)
		{
			
			pagerContext.addBeanParams(name,encode,"",this.encodecount);
			
			return EVAL_BODY_INCLUDE;
		}
		else 
		/**
		��param��ǩ������list��ǩ��ʱ��
		�������´��������������pager��ǩ�����ҽ�paramҲ����list��ǩ�У���������ǷǷ���
		���ǳ���û������Ӧ���жϡ�
		*/
		{
			PagerDataSet listTag = (PagerDataSet) findAncestorWithClass(this, PagerDataSet.class);
			if(listTag != null && listTag.getRowid() == 0)
			{
				pagerContext = listTag.getPagerContext();
				
				pagerContext.addBeanParams(name,encode,"",this.encodecount);
				
				return EVAL_BODY_INCLUDE; 
			}
			else
			{
				return SKIP_BODY;
			}
			
			
		}
		
	}

	public void release() {
		name = null;
		
		super.release();
	}

	/* (non-Javadoc)
	 * @see com.frameworkset.common.tag.BaseTag#generateContent()
	 */
	public String generateContent() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.frameworkset.common.tag.BaseTag#write(java.io.OutputStream)
	 */
	public void write(OutputStream output) {
		// TODO Auto-generated method stub

	}
}