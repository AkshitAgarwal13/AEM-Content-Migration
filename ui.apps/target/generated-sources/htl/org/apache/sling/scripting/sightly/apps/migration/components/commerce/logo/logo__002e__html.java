/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.sling.scripting.sightly.apps.migration.components.commerce.logo;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class logo__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_component = null;
Object _global_templates = null;
Object _global_logoname = null;
Object _dynamic_header = bindings.get("header");
Object _global_testpath = null;
Object _dynamic_resource = bindings.get("resource");
Object _global_hasimage = null;
out.write("\r\n");
_global_component = renderContext.call("use", com.adobe.cq.wcm.core.components.models.Component.class.getName(), obj());
_global_templates = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
_global_logoname = "logo.svg";
out.write("\r\n<a");
{
    Object var_attrvalue0 = renderContext.getObjectModel().resolveProperty(_global_component, "id");
    {
        Object var_attrcontent1 = renderContext.call("xss", var_attrvalue0, "attribute");
        {
            boolean var_shoulddisplayattr3 = (((null != var_attrcontent1) && (!"".equals(var_attrcontent1))) && ((!"".equals(var_attrvalue0)) && (!((Object)false).equals(var_attrvalue0))));
            if (var_shoulddisplayattr3) {
                out.write(" id");
                {
                    boolean var_istrueattr2 = (var_attrvalue0.equals(true));
                    if (!var_istrueattr2) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent1));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(" class=\"logo__link\"");
{
    Object var_attrvalue4 = renderContext.getObjectModel().resolveProperty(_dynamic_header, "navigationRootPageUrl");
    {
        Object var_attrcontent5 = renderContext.call("xss", var_attrvalue4, "uri");
        {
            boolean var_shoulddisplayattr7 = (((null != var_attrcontent5) && (!"".equals(var_attrcontent5))) && ((!"".equals(var_attrvalue4)) && (!((Object)false).equals(var_attrvalue4))));
            if (var_shoulddisplayattr7) {
                out.write(" href");
                {
                    boolean var_istrueattr6 = (var_attrvalue4.equals(true));
                    if (!var_istrueattr6) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent5));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(">\r\n    ");
_global_testpath = (renderContext.getObjectModel().toString(_global_logoname) + "/jcr:primaryType");
_global_hasimage = renderContext.getObjectModel().resolveProperty(_dynamic_resource, _global_testpath);
if (renderContext.getObjectModel().toBoolean(_global_hasimage)) {
    out.write("<img class=\"logo__image\"");
    {
        String var_attrcontent8 = ((renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_resource, "path"), "uri")) + "/") + renderContext.getObjectModel().toString(renderContext.call("xss", _global_logoname, "uri")));
        out.write(" src=\"");
        out.write(renderContext.getObjectModel().toString(var_attrcontent8));
        out.write("\"");
    }
    out.write(" height=\"24\"");
    {
        Object var_attrvalue9 = renderContext.getObjectModel().resolveProperty(_dynamic_header, "navigationRootPageTitle");
        {
            Object var_attrcontent10 = renderContext.call("xss", var_attrvalue9, "attribute");
            {
                boolean var_shoulddisplayattr12 = (((null != var_attrcontent10) && (!"".equals(var_attrcontent10))) && ((!"".equals(var_attrvalue9)) && (!((Object)false).equals(var_attrvalue9))));
                if (var_shoulddisplayattr12) {
                    out.write(" alt");
                    {
                        boolean var_istrueattr11 = (var_attrvalue9.equals(true));
                        if (!var_istrueattr11) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent10));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    {
        Object var_attrvalue13 = renderContext.getObjectModel().resolveProperty(_dynamic_header, "navigationRootPageTitle");
        {
            Object var_attrcontent14 = renderContext.call("xss", var_attrvalue13, "attribute");
            {
                boolean var_shoulddisplayattr16 = (((null != var_attrcontent14) && (!"".equals(var_attrcontent14))) && ((!"".equals(var_attrvalue13)) && (!((Object)false).equals(var_attrvalue13))));
                if (var_shoulddisplayattr16) {
                    out.write(" title");
                    {
                        boolean var_istrueattr15 = (var_attrvalue13.equals(true));
                        if (!var_istrueattr15) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent14));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    out.write("/>");
}
out.write("\r\n    ");
{
    boolean var_testvariable17 = (!renderContext.getObjectModel().toBoolean(_global_hasimage));
    if (var_testvariable17) {
        {
            Object var_18 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_header, "navigationRootPageTitle"), "text");
            out.write(renderContext.getObjectModel().toString(var_18));
        }
    }
}
out.write("\r\n</a>\r\n");
{
    Object var_templatevar19 = renderContext.getObjectModel().resolveProperty(_global_templates, "placeholder");
    {
        boolean var_templateoptions20_field$_isempty = ((!renderContext.getObjectModel().toBoolean(_global_hasimage)) && (!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_header, "navigationRootPageTitle"))));
        {
            java.util.Map var_templateoptions20 = obj().with("isEmpty", var_templateoptions20_field$_isempty);
            callUnit(out, renderContext, var_templatevar19, var_templateoptions20);
        }
    }
}


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

