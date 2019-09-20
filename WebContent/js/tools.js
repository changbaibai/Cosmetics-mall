/*
 * 使用正则表达式验证    需要jquery 
 * 	res 正则表达式
 * 	obj 需要验证的字符串
 *  return true/false 
 */
function Verification(res, obj) {
	//用户名     3-8位 支持中文     
	//  /[\u4e00-\u9fa5a-zA-Z0-9_]{3,8}/
	//密码    6-16位 字母数字下划线
	//  /^[a-zA-Z0-9_]{6,16}$/
	//手机号     11位
	//  /0?(13|14|15|17|18|19)[0-9]{9}/
	//邮箱
	//  /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/
	if (res != null && obj != null) {
		return res.test(obj);
	}
}