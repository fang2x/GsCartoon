package com.gs.gscartoon.utils;

import android.content.Context;

import com.gs.gscartoon.GsApplication;
import com.gs.gscartoon.R;

/**
 * Created by camdora on 17-3-16. 12:05
 */

public class ErrorUtil {
    private final static String TAG = "ErrorUtil";

    public final static int ACCESS_NETWORK_ERROR = -1001;//访问网络出错。
    public final static int DATA_ERROR = -1002;//返回的数据有问题，或许解析json出错
    public final static int BAD_REQUEST = 400;//错误的请求	该请求是无效的。相应的描述信息会说明原因。
    public final static int NOT_AUTHENTICATED = 401;//未验证	没有验证信息或者验证失败。
    public final static int FORBIDDEN = 403;//被拒绝	理解该请求，但不被接受。相应的描述信息会说明原因。
    public final static int NOT_FOUND = 404;//无法找到	资源不存在，请求的用户的不存在，请求的格式不被支持。
    public final static int METHOD_NOT_ALLOWED = 405;//请求方法不合适	该接口不支持该方法的请求。
    public final static int ACCOUNT_HAS_BEEN_BOUND = 409;//该账号已绑定其他用户，请先解绑
    public final static int ONLY_HAVE_ONE_CAN_LOGIN_ACCOUNT = 422;//您只有一个可登陆账号，不能再解绑
    public final static int TOO_MANY_REQUESTS = 429;//过多的请求	请求超出了频率限制。相应的描述信息会解释具体的原因。
    public final static int GENERAL_ERROR = 500;//内部服务错误	服务器内部出错了。请联系我们尽快解决问题。
    public final static int BAD_GATEWAY = 502;//无效代理	业务服务器下线了或者正在升级。请稍后重试。
    public final static int UNAVAILABLE = 503;//服务暂时失效	服务器无法响应请求。请稍后重试。

    public static void showErrorInfo(int errorCode){

        Context context = GsApplication.getAppContext();

        switch (errorCode){
            case ACCESS_NETWORK_ERROR:
                ToastUtil.showToastShort(R.string.access_network_error);
                break;
            case DATA_ERROR:
                ToastUtil.showToastShort(R.string.data_returned_wrong);
                break;
            case BAD_REQUEST:
                ToastUtil.showToastShort(R.string.bad_request);
                break;
            case NOT_AUTHENTICATED:
                ToastUtil.showToastShort(R.string.no_verification);
                break;
            case FORBIDDEN:
                ToastUtil.showToastShort(R.string.access_is_denied);
                break;
            case NOT_FOUND:
                ToastUtil.showToastShort(R.string.resource_does_not_exist);
                break;
            case METHOD_NOT_ALLOWED:
                ToastUtil.showToastShort(R.string.request_method_is_not_appropriate);
                break;
            case ACCOUNT_HAS_BEEN_BOUND:
                ToastUtil.showToastShort(R.string.account_has_been_bound_to_other_users);
                break;
            case ONLY_HAVE_ONE_CAN_LOGIN_ACCOUNT:
                ToastUtil.showToastShort(R.string.you_only_have_one_can_login_account);
                break;
            case TOO_MANY_REQUESTS:
                ToastUtil.showToastShort(R.string.too_much_request);
                break;
            case GENERAL_ERROR:
                ToastUtil.showToastShort(R.string.There_was_an_error_inside_server);
                break;
            case BAD_GATEWAY:
                ToastUtil.showToastShort(R.string.invalid_proxy);
                break;
            case UNAVAILABLE:
                ToastUtil.showToastShort(R.string.service_is_temporarily_suspended);
                break;
            default:
                ToastUtil.showToastShort(R.string.access_network_error);
                break;
        }
    }
}
