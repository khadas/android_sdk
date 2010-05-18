/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Eclipse Public License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.eclipse.org/org/documents/epl-v10.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.ide.eclipse.adt.internal.resources.configurations;

import com.android.ide.eclipse.adt.internal.editors.IconFactory;
import com.android.sdklib.IAndroidTarget;
import com.android.sdklib.resources.Navigation;

import org.eclipse.swt.graphics.Image;

/**
 * Resource Qualifier for Navigation Method.
 */
public final class NavigationMethodQualifier extends ResourceQualifier {

    public static final String NAME = "Navigation Method";

    private Navigation mValue;

    public NavigationMethodQualifier() {
        // pass
    }

    public NavigationMethodQualifier(Navigation value) {
        mValue = value;
    }

    public Navigation getValue() {
        return mValue;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getShortName() {
        return "Navigation";
    }


    @Override
    public Image getIcon() {
        return IconFactory.getInstance().getIcon("navpad"); //$NON-NLS-1$
    }

    @Override
    public boolean isValid() {
        return mValue != null;
    }

    @Override
    public boolean checkAndSet(String value, FolderConfiguration config) {
        Navigation method = Navigation.getEnum(value);
        if (method != null) {
            NavigationMethodQualifier qualifier = new NavigationMethodQualifier(method);
            config.setNavigationMethodQualifier(qualifier);
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object qualifier) {
        if (qualifier instanceof NavigationMethodQualifier) {
            return mValue == ((NavigationMethodQualifier)qualifier).mValue;
        }

        return false;
    }

    @Override
    public int hashCode() {
        if (mValue != null) {
            return mValue.hashCode();
        }

        return 0;
    }

    /**
     * Returns the string used to represent this qualifier in the folder name.
     */
    @Override
    public String getFolderSegment(IAndroidTarget target) {
        if (mValue != null) {
            return mValue.getValue();
        }

        return ""; //$NON-NLS-1$
    }

    @Override
    public String getStringValue() {
        if (mValue != null) {
            return mValue.getDisplayValue();
        }

        return ""; //$NON-NLS-1$
    }
}
