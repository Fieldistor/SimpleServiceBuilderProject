package Test.service.persistence;

import Test.model.Foo;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import java.util.List;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class FooFinderImpl extends BasePersistenceImpl implements FooFinder
{
    public static String DELETE_Foo = "deleteFoo";

    public void deleteCustomFoo(String data) throws SystemException {
        Session session = null;
        try {
            session = openSession();
            String sql = CustomSQLUtil.get(DELETE_Foo);
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity("Foo", Foo.class);
            QueryPos qPos = QueryPos.getInstance(query);
            qPos.add(data);
            query.executeUpdate();
        }catch (Exception e) {  }
    }
}
