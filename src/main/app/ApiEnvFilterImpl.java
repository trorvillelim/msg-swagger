package main.app;

import io.swagger.core.filter.AbstractSpecFilter;
import io.swagger.model.ApiDescription;
import io.swagger.models.Model;
import io.swagger.models.Operation;
import io.swagger.models.properties.Property;
import main.annotation.OperationHidden;
import main.models.UserSession;
import io.swagger.models.parameters.Parameter;
import main.models.Valuation;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

/**
 * Created by orvillelim on 14/09/2017.
 * <p>
 * This filter any apis from package main.api base on environment
 */

public class ApiEnvFilterImpl extends AbstractSpecFilter {

    private AppEnvironmentUtil appEnvironmentUtil = new AppEnvironmentUtil();
    private UserSession userSession;

    public ApiEnvFilterImpl(UserSession userSession )
    {
        this.userSession = userSession;
        appEnvironmentUtil.initializeEnvironmentApis();

    }

    @Override
    public boolean isOperationAllowed(
            Operation operation,
            ApiDescription api,
            Map<String, List<String>> params,
            Map<String, String> cookies,
            Map<String, List<String>> headers) {

        String methodName = operation.getOperationId(); // e.x getVersion
        Map<String, List> map = appEnvironmentUtil.getMethods();

        if (map.containsKey(methodName)) {

            if (map.get(methodName).contains(userSession.getEnvironment())) {
                return true;
            }
        }

        return true;
    }

    public boolean isParamAllowed(
            Parameter parameter,
            Operation operation,
            ApiDescription api,
            Map<String, List<String>> params,
            Map<String, String> cookies,
            Map<String, List<String>> headers) {

        return true;
    }

    @Override
    public boolean isPropertyAllowed(
            Model model,
            Property property,
            String propertyName,
            Map<String, List<String>> params,
            Map<String, String> cookies,
            Map<String, List<String>> headers) {

        return true;
    }


}
