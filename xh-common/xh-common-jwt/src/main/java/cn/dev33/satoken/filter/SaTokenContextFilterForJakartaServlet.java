/*
 * Copyright 2020-2099 sa-token.cc
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
package cn.dev33.satoken.filter;

import cn.dev33.satoken.servlet.util.SaTokenContextJakartaServletUtil;
import cn.dev33.satoken.util.SaTokenConsts;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;

import java.io.IOException;

/**
 * SaTokenContext 上下文初始化过滤器 (基于 Jakarta-Servlet)
 *
 * @author click33
 * @since 1.42.0
 */
@Order(SaTokenConsts.SA_TOKEN_CONTEXT_FILTER_ORDER)
public class SaTokenContextFilterForJakartaServlet implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			SaTokenContextJakartaServletUtil.setContext((HttpServletRequest) request, (HttpServletResponse) response);
			chain.doFilter(request, response);
		} finally {
			SaTokenContextJakartaServletUtil.clearContext();
		}
	}

}
