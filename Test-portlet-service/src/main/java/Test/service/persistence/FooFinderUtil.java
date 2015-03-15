package Test.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class FooFinderUtil {
    private static FooFinder _finder;

    public static void deleteCustomFoo(java.lang.String data)
        throws com.liferay.portal.kernel.exception.SystemException {
        getFinder().deleteCustomFoo(data);
    }

    public static FooFinder getFinder() {
        if (_finder == null) {
            _finder = (FooFinder) PortletBeanLocatorUtil.locate(Test.service.ClpSerializer.getServletContextName(),
                    FooFinder.class.getName());

            ReferenceRegistry.registerReference(FooFinderUtil.class, "_finder");
        }

        return _finder;
    }

    public void setFinder(FooFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(FooFinderUtil.class, "_finder");
    }
}
