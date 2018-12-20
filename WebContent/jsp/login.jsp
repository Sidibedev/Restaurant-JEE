<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title><s:text name="app.login.titre"></s:text></title>
<style type="text/css">
	@import url(ressources/css/bootstrap.css);
</style>
</head>
<body>
	<main role="main" class="container" style="margin-top: 100px;">
		<h1>
			<s:text name="app.login.titre"></s:text>
		</h1>
		<hr />
		<s:if test="errorMessage.size()>0">
			<div id="msg_erreur" class="alert-danger">
				<s:actionerror/>
			</div>
		</s:if>
		<s:if test="errors.size()>0">
			<div id="msg_erreur">
				<s:fielderror/>
			</div>
		</s:if>
		<s:form method="POST" action="authentifier_User">
			<s:textfield name="username" id="username" 
				label="%{getText('app.login.username')}" labelposition="right" class="form-control form-control-lg text-input">
			</s:textfield>
			<s:password name="password" id="password" 
				label="%{getText('app.login.password')}" labelposition="right" class="form-control form-control-lg text-input">
			</s:password>
			<s:submit value="%{getText('app.form.login')}" class="btn-lg btn-submit btn-success"></s:submit>
		</s:form>
	</main>
	<script src ="ressources/js/proper.min.js"></script>
	<script src ="ressources/js/bootstrap.min.js"></script>
</body>
</html>