package Test.user;

import Test.model.Foo;
import Test.service.FooLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import java.util.List;

public class MainAction extends MVCPortlet {
    public void addFoo(ActionRequest actionRequest, ActionResponse actionResponse){
        ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
        try {
            FooLocalServiceUtil.addUserFoo(
                    themeDisplay.getSiteGroupId(),
                    themeDisplay.getCompanyId(),
                    themeDisplay.getUserId(),
                    ParamUtil.getString(actionRequest, "name"));
        } catch (SystemException e) {
            e.printStackTrace();
        }
    }

    public void deleteFoo(ActionRequest actionRequest, ActionResponse actionResponse){
        ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
        try {
            FooLocalServiceUtil.deleteUserFoo(
                    ParamUtil.getLong(actionRequest, "id"),themeDisplay.getCompanyId());
        } catch (PortalException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        }
    }

    public static List<Foo> getFoo(RenderRequest renderRequest){
        List<Foo> fooList = FooLocalServiceUtil.getAllFoo();
        return fooList;
    }
}
