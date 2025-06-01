2025-05-16T22:51:11.004+04:00  INFO 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-05-16T22:51:11.004+04:00  INFO 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-05-16T22:51:11.004+04:00 DEBUG 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.web.servlet.DispatcherServlet        : Detected StandardServletMultipartResolver
2025-05-16T22:51:11.005+04:00 DEBUG 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.web.servlet.DispatcherServlet        : Detected AcceptHeaderLocaleResolver
2025-05-16T22:51:11.005+04:00 DEBUG 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.web.servlet.DispatcherServlet        : Detected FixedThemeResolver
2025-05-16T22:51:11.006+04:00 DEBUG 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.web.servlet.DispatcherServlet        : Detected org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator@4c822e9b
2025-05-16T22:51:11.006+04:00 DEBUG 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.web.servlet.DispatcherServlet        : Detected org.springframework.web.servlet.support.SessionFlashMapManager@6b909973
2025-05-16T22:51:11.006+04:00 DEBUG 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.web.servlet.DispatcherServlet        : enableLoggingRequestDetails='false': request parameters and headers will be masked to prevent unsafe logging of potentially sensitive data
2025-05-16T22:51:11.006+04:00  INFO 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms
2025-05-16T22:51:11.017+04:00 DEBUG 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] s.s.w.f.HttpStatusRequestRejectedHandler : Rejecting request due to: The request was rejected because the URL contained a potentially malicious String "//"

org.springframework.security.web.firewall.RequestRejectedException: The request was rejected because the URL contained a potentially malicious String "//"
at org.springframework.security.web.firewall.StrictHttpFirewall.rejectedBlocklistedUrls(StrictHttpFirewall.java:548) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.firewall.StrictHttpFirewall.getFirewalledRequest(StrictHttpFirewall.java:518) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:211) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:191) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.web.filter.CompositeFilter$VirtualFilterChain.doFilter(CompositeFilter.java:113) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.web.servlet.handler.HandlerMappingIntrospector.lambda$createCacheFilter$3(HandlerMappingIntrospector.java:243) ~[spring-webmvc-6.2.3.jar:6.2.3]
at org.springframework.web.filter.CompositeFilter$VirtualFilterChain.doFilter(CompositeFilter.java:113) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.web.filter.CompositeFilter.doFilter(CompositeFilter.java:74) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.security.config.annotation.web.configuration.WebMvcSecurityConfiguration$CompositeFilterChainProxy.doFilter(WebMvcSecurityConfiguration.java:238) ~[spring-security-config-6.4.3.jar:6.4.3]
at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:362) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:278) ~[spring-web-6.2.3.jar:6.2.3]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.2.3.jar:6.2.3]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.2.3.jar:6.2.3]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.2.3.jar:6.2.3]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:483) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:115) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:344) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:397) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:905) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1743) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1190) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at java.base/java.lang.Thread.run(Thread.java:1583) ~[na:na]

2025-05-16T22:51:11.038+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Trying to match request against DefaultSecurityFilterChain defined as 'securityFilterChain' in [class path resource [com/example/myapp/SpringSecurityConfig.class]] matching [any request] and having filters [DisableEncodeUrl, WebAsyncManagerIntegration, SecurityContextHolder, HeaderWriter, JwtCsrf, Csrf, Logout, BasicAuthentication, RequestCacheAware, SecurityContextHolderAwareRequest, AnonymousAuthentication, SessionManagement, ExceptionTranslation, Authorization] (1/1)
2025-05-16T22:51:11.039+04:00 DEBUG 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Securing POST /error
2025-05-16T22:51:11.040+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking DisableEncodeUrlFilter (1/14)
2025-05-16T22:51:11.041+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking WebAsyncManagerIntegrationFilter (2/14)
2025-05-16T22:51:11.041+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking SecurityContextHolderFilter (3/14)
2025-05-16T22:51:11.042+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking HeaderWriterFilter (4/14)
2025-05-16T22:51:11.042+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking JwtCsrfFilter (5/14)
2025-05-16T22:51:11.042+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking CsrfFilter (6/14)
2025-05-16T22:51:11.042+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking LogoutFilter (7/14)
2025-05-16T22:51:11.042+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.s.w.a.logout.LogoutFilter            : Did not match request to Ant [pattern='/logout', POST]
2025-05-16T22:51:11.042+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking BasicAuthenticationFilter (8/14)
2025-05-16T22:51:11.042+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking RequestCacheAwareFilter (9/14)
2025-05-16T22:51:11.042+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.s.w.s.HttpSessionRequestCache        : matchingRequestParameterName is required for getMatchingRequest to lookup a value, but not provided
2025-05-16T22:51:11.042+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking SecurityContextHolderAwareRequestFilter (10/14)
2025-05-16T22:51:11.043+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking AnonymousAuthenticationFilter (11/14)
2025-05-16T22:51:11.043+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking SessionManagementFilter (12/14)
2025-05-16T22:51:11.043+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] w.c.HttpSessionSecurityContextRepository : No HttpSession currently exists
2025-05-16T22:51:11.043+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] .s.s.w.c.SupplierDeferredSecurityContext : Created SecurityContextImpl [Null authentication]
2025-05-16T22:51:11.043+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] .s.s.w.c.SupplierDeferredSecurityContext : Created SecurityContextImpl [Null authentication]
2025-05-16T22:51:11.044+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.s.w.a.AnonymousAuthenticationFilter  : Set SecurityContextHolder to AnonymousAuthenticationToken [Principal=anonymousUser, Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=null], Granted Authorities=[ROLE_ANONYMOUS]]
2025-05-16T22:51:11.044+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking ExceptionTranslationFilter (13/14)
2025-05-16T22:51:11.044+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking AuthorizationFilter (14/14)
2025-05-16T22:51:11.044+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] estMatcherDelegatingAuthorizationManager : Authorizing POST /error
2025-05-16T22:51:11.045+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] estMatcherDelegatingAuthorizationManager : Denying request since did not find matching RequestMatcher
2025-05-16T22:51:11.045+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.s.w.a.ExceptionTranslationFilter     : Sending AnonymousAuthenticationToken [Principal=anonymousUser, Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=null], Granted Authorities=[ROLE_ANONYMOUS]] to authentication entry point since access is denied

org.springframework.security.authorization.AuthorizationDeniedException: Access Denied
at org.springframework.security.web.access.intercept.AuthorizationFilter.doFilter(AuthorizationFilter.java:99) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:374) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:126) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:120) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:374) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:131) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:85) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:374) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:100) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:374) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:179) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:374) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:374) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:374) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:107) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:93) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:374) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:374) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:374) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:374) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:82) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:69) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:374) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:374) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:374) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:233) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:191) ~[spring-security-web-6.4.3.jar:6.4.3]
at org.springframework.web.filter.CompositeFilter$VirtualFilterChain.doFilter(CompositeFilter.java:113) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.web.servlet.handler.HandlerMappingIntrospector.lambda$createCacheFilter$3(HandlerMappingIntrospector.java:243) ~[spring-webmvc-6.2.3.jar:6.2.3]
at org.springframework.web.filter.CompositeFilter$VirtualFilterChain.doFilter(CompositeFilter.java:113) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.web.filter.CompositeFilter.doFilter(CompositeFilter.java:74) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.security.config.annotation.web.configuration.WebMvcSecurityConfiguration$CompositeFilterChainProxy.doFilter(WebMvcSecurityConfiguration.java:238) ~[spring-security-config-6.4.3.jar:6.4.3]
at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:362) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:278) ~[spring-web-6.2.3.jar:6.2.3]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-6.2.3.jar:6.2.3]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.2.3.jar:6.2.3]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101) ~[spring-web-6.2.3.jar:6.2.3]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101) ~[spring-web-6.2.3.jar:6.2.3]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.ApplicationDispatcher.invoke(ApplicationDispatcher.java:633) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.ApplicationDispatcher.processRequest(ApplicationDispatcher.java:411) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.ApplicationDispatcher.doForward(ApplicationDispatcher.java:331) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.ApplicationDispatcher.forward(ApplicationDispatcher.java:268) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.StandardHostValve.custom(StandardHostValve.java:380) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.StandardHostValve.status(StandardHostValve.java:208) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:151) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:344) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:397) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:905) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1743) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1190) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63) ~[tomcat-embed-core-10.1.36.jar:10.1.36]
at java.base/java.lang.Thread.run(Thread.java:1583) ~[na:na]

2025-05-16T22:51:11.049+04:00 TRACE 35040 --- [BD_SPASIBO_1_idea] [nio-8080-exec-3] o.s.s.w.s.HttpSessionRequestCache        : Did not save request since it did not match [And [Ant [pattern='/**', GET], Not [Ant [pattern='/**/favicon.*']], Not [MediaTypeRequestMatcher [contentNegotiationStrategy=org.springframework.web.accept.ContentNegotiationManager@5135b459, matchingMediaTypes=[application/json], useEquals=false, ignoredMediaTypes=[*/*]]], Not [RequestHeaderRequestMatcher [expectedHeaderName=X-Requested-With, expectedHeaderValue=XMLHttpRequest]], Not [MediaTypeRequestMatcher [contentNegotiationStrategy=org.springframework.web.accept.ContentNegotiationManager@5135b459, matchingMediaTypes=[multipart/form-data], useEquals=false, ignoredMediaTypes=[*/*]]], Not [MediaTypeRequestMatcher [contentNegotiationStrategy=org.springframework.web.accept.ContentNegotiationManager@5135b459, matchingMediaTypes=[text/event-stream], useEquals=false, ignoredMediaTypes=[*/*]]]]]


package com.example.myapp.config;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.security.web.csrf.MissingCsrfTokenException;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

public class JwtCsrfFilter extends OncePerRequestFilter {

    private final CsrfTokenRepository tokenRepository;

    private final HandlerExceptionResolver resolver;

    public JwtCsrfFilter(CsrfTokenRepository tokenRepository, HandlerExceptionResolver resolver) {
        System.out.println("JwtCsrfFilter !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        this.tokenRepository = tokenRepository;
        this.resolver = resolver;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            System.out.println("JwtCsrfFilter  doFilterInternal!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            request.setAttribute(HttpServletResponse.class.getName(), response); //мне кажется, тут нужна отдельная реализация для register
            CsrfToken csrfToken = this.tokenRepository.loadToken(request);
            boolean missingToken = csrfToken == null;
            if (missingToken) {
                csrfToken = this.tokenRepository.generateToken(request);
                this.tokenRepository.saveToken(csrfToken, request, response);
            }

            request.setAttribute(CsrfToken.class.getName(), csrfToken);
            request.setAttribute(csrfToken.getParameterName(), csrfToken);
            if (request.getServletPath().equals("/auth/login") | request.getServletPath().equals("/auth/register")) {
                try {
                    filterChain.doFilter(request, response);
                } catch (Exception e) {
                    resolver.resolveException(request, response, null, new MissingCsrfTokenException(csrfToken.getToken()));
                }
            } else {
                String actualToken = request.getHeader(csrfToken.getHeaderName());
                if (actualToken == null) {
                    actualToken = request.getParameter(csrfToken.getParameterName());
                }
                try {
                    if (!StringUtils.isEmpty(actualToken)) {
                        Jwts.parser()
                                .setSigningKey(((JwtTokenRepository) tokenRepository).getSecret())
                                .parseClaimsJws(actualToken);

                        filterChain.doFilter(request, response);
                    } else
                        resolver.resolveException(request, response, null, new InvalidCsrfTokenException(csrfToken, actualToken));
                } catch (JwtException e) {
                    if (this.logger.isDebugEnabled()) {
                        this.logger.debug("Invalid CSRF token found for " + UrlUtils.buildFullRequestUrl(request));
                    }

                    if (missingToken) {
                        resolver.resolveException(request, response, null, new MissingCsrfTokenException(actualToken));
                    } else {
                        resolver.resolveException(request, response, null, new InvalidCsrfTokenException(csrfToken, actualToken));
                    }
                }
            }
    }
}

package com.example.myapp.config;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;

import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS;

@Repository
public class JwtTokenRepository implements CsrfTokenRepository {
@Value("${jwt.secret}")
private String secret;     //можно потом добавить связь с номером телефона пользователя
@Value("${jwt.expiration-ms}")
private long expirationMs;

    public JwtTokenRepository() {
        System.out.println("JwtTokenRepository!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
    public String getSecret() {
        System.out.println("JwtTokenRepository    getSecret!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        return secret;
    }
    @Override
    public CsrfToken generateToken(HttpServletRequest httpServletRequest) {
        System.out.println("JwtTokenRepository    generateToken!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String id = UUID.randomUUID().toString().replace("-", "");
        Date now = new Date();
        Date exp = Date.from(Instant.now().plusMillis(expirationMs));

        String token = "";
        try {
            token = Jwts.builder()
                    .setId(id)
                    .setIssuedAt(now)
                    .setNotBefore(now)
                    .setExpiration(exp)
                    .signWith(SignatureAlgorithm.HS256, secret)
                    .compact();
        } catch (JwtException e) {
            e.printStackTrace();   //не очень хорошая обработка (просто выводит ошибку в логи и возвращает пустой токен)
        }
        return new DefaultCsrfToken("x-csrf-token", "_csrf", token);
    }

    @Override
    public void saveToken(CsrfToken csrfToken, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("JwtTokenRepository    saveToken!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        if (Objects.nonNull(csrfToken)) {
            /*if (!response.getHeaderNames().contains(ACCESS_CONTROL_EXPOSE_HEADERS))              //это вроде только для js
                response.addHeader(ACCESS_CONTROL_EXPOSE_HEADERS, csrfToken.getHeaderName());*/

            if (response.getHeaderNames().contains(csrfToken.getHeaderName())) {
                System.out.println("JwtTokenRepository    saveToken1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                response.setHeader(csrfToken.getHeaderName(), csrfToken.getToken());
            }
            else {
                System.out.println("JwtTokenRepository    saveToken2!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                response.addHeader(csrfToken.getHeaderName(), csrfToken.getToken());
            }
        }
    }

    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
        System.out.println("JwtTokenRepository    loadToken!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }

    public void clearToken(HttpServletResponse response) {
        System.out.println("JwtTokenRepository    clearToken!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        if (response.getHeaderNames().contains("x-csrf-token"))
            response.setHeader("x-csrf-token", "");
    }
}
