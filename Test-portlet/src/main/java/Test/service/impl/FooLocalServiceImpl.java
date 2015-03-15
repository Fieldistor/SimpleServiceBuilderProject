package Test.service.impl;

import Test.model.Foo;
import Test.model.impl.FooImpl;
import Test.service.FooLocalServiceUtil;
import Test.service.base.FooLocalServiceBaseImpl;
import Test.service.persistence.FooFinderUtil;
import Test.service.persistence.FooUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ResourceLocalServiceUtil;

import java.util.List;

public class FooLocalServiceImpl extends FooLocalServiceBaseImpl {

    public void addUserFoo(long groupId,long companyId,
                       long userId, String data) throws SystemException {
        long fooId = CounterLocalServiceUtil.increment(Foo.class.getName());
        Foo newFoo = new FooImpl();
        newFoo.setPrimaryKey(fooId);
        newFoo.setGroupId(groupId);
        newFoo.setCompanyId(companyId);
        newFoo.setUserId(userId);
        newFoo.setUserName(data);
        FooLocalServiceUtil.addFoo(newFoo);
        try {
            ResourceLocalServiceUtil.addResources(companyId,
                    groupId,userId,Foo.class.getName(),
                    newFoo.getPrimaryKey(),false,
                    true,true);
        } catch (PortalException e) {
            e.printStackTrace();
        }
    }


    public void deleteUserFoo(long fooId,long companyId) throws SystemException, PortalException {
        FooLocalServiceUtil.deleteFoo(fooId);
        ResourceLocalServiceUtil.deleteResource(companyId,Foo.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,fooId);
    }


    public List<Foo> getAllFoo(){
        List<Foo> foos=null;
        try {
            foos= FooUtil.findAll();
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return foos;
    }
}
