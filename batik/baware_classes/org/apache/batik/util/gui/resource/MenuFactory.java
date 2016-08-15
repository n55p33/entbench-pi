package org.apache.batik.util.gui.resource;
public class MenuFactory extends org.apache.batik.util.resources.ResourceManager {
    private static final java.lang.String TYPE_MENU = "MENU";
    private static final java.lang.String TYPE_ITEM = "ITEM";
    private static final java.lang.String TYPE_RADIO = "RADIO";
    private static final java.lang.String TYPE_CHECK = "CHECK";
    private static final java.lang.String SEPARATOR = "-";
    private static final java.lang.String TYPE_SUFFIX = ".type";
    private static final java.lang.String TEXT_SUFFIX = ".text";
    private static final java.lang.String MNEMONIC_SUFFIX = ".mnemonic";
    private static final java.lang.String ACCELERATOR_SUFFIX = ".accelerator";
    private static final java.lang.String ACTION_SUFFIX = ".action";
    private static final java.lang.String SELECTED_SUFFIX = ".selected";
    private static final java.lang.String ENABLED_SUFFIX = ".enabled";
    private static final java.lang.String ICON_SUFFIX = ".icon";
    private org.apache.batik.util.gui.resource.ActionMap actions;
    private javax.swing.ButtonGroup buttonGroup;
    public MenuFactory(java.util.ResourceBundle rb, org.apache.batik.util.gui.resource.ActionMap am) {
        super(
          rb);
        actions =
          am;
        buttonGroup =
          null;
    }
    public javax.swing.JMenuBar createJMenuBar(java.lang.String name)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        return createJMenuBar(
                 name,
                 null);
    }
    public javax.swing.JMenuBar createJMenuBar(java.lang.String name,
                                               java.lang.String specialization)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        javax.swing.JMenuBar result =
          new javax.swing.JMenuBar(
          );
        java.util.List menus =
          getSpecializedStringList(
            name,
            specialization);
        java.util.Iterator it =
          menus.
          iterator(
            );
        while (it.
                 hasNext(
                   )) {
            result.
              add(
                createJMenuComponent(
                  (java.lang.String)
                    it.
                    next(
                      ),
                  specialization));
        }
        return result;
    }
    protected java.lang.String getSpecializedString(java.lang.String name,
                                                    java.lang.String specialization) {
        java.lang.String s;
        try {
            s =
              getString(
                name +
                '.' +
                specialization);
        }
        catch (java.util.MissingResourceException mre) {
            s =
              getString(
                name);
        }
        return s;
    }
    protected java.util.List getSpecializedStringList(java.lang.String name,
                                                      java.lang.String specialization) {
        java.util.List l;
        try {
            l =
              getStringList(
                name +
                '.' +
                specialization);
        }
        catch (java.util.MissingResourceException mre) {
            l =
              getStringList(
                name);
        }
        return l;
    }
    protected boolean getSpecializedBoolean(java.lang.String name,
                                            java.lang.String specialization) {
        boolean b;
        try {
            b =
              getBoolean(
                name +
                '.' +
                specialization);
        }
        catch (java.util.MissingResourceException mre) {
            b =
              getBoolean(
                name);
        }
        return b;
    }
    protected javax.swing.JComponent createJMenuComponent(java.lang.String name,
                                                          java.lang.String specialization)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        if (name.
              equals(
                SEPARATOR)) {
            buttonGroup =
              null;
            return new javax.swing.JSeparator(
              );
        }
        java.lang.String type =
          getSpecializedString(
            name +
            TYPE_SUFFIX,
            specialization);
        javax.swing.JComponent item =
          null;
        if (type.
              equals(
                TYPE_RADIO)) {
            if (buttonGroup ==
                  null) {
                buttonGroup =
                  new javax.swing.ButtonGroup(
                    );
            }
        }
        else {
            buttonGroup =
              null;
        }
        if (type.
              equals(
                TYPE_MENU)) {
            item =
              createJMenu(
                name,
                specialization);
        }
        else
            if (type.
                  equals(
                    TYPE_ITEM)) {
                item =
                  createJMenuItem(
                    name,
                    specialization);
            }
            else
                if (type.
                      equals(
                        TYPE_RADIO)) {
                    item =
                      createJRadioButtonMenuItem(
                        name,
                        specialization);
                    buttonGroup.
                      add(
                        (javax.swing.AbstractButton)
                          item);
                }
                else
                    if (type.
                          equals(
                            TYPE_CHECK)) {
                        item =
                          createJCheckBoxMenuItem(
                            name,
                            specialization);
                    }
                    else {
                        throw new org.apache.batik.util.resources.ResourceFormatException(
                          "Malformed resource",
                          bundle.
                            getClass(
                              ).
                            getName(
                              ),
                          name +
                          TYPE_SUFFIX);
                    }
        return item;
    }
    public javax.swing.JMenu createJMenu(java.lang.String name)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        return createJMenu(
                 name,
                 null);
    }
    public javax.swing.JMenu createJMenu(java.lang.String name,
                                         java.lang.String specialization)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        javax.swing.JMenu result =
          new javax.swing.JMenu(
          getSpecializedString(
            name +
            TEXT_SUFFIX,
            specialization));
        initializeJMenuItem(
          result,
          name,
          specialization);
        java.util.List items =
          getSpecializedStringList(
            name,
            specialization);
        java.util.Iterator it =
          items.
          iterator(
            );
        while (it.
                 hasNext(
                   )) {
            result.
              add(
                createJMenuComponent(
                  (java.lang.String)
                    it.
                    next(
                      ),
                  specialization));
        }
        return result;
    }
    public javax.swing.JMenuItem createJMenuItem(java.lang.String name)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        return createJMenuItem(
                 name,
                 null);
    }
    public javax.swing.JMenuItem createJMenuItem(java.lang.String name,
                                                 java.lang.String specialization)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        javax.swing.JMenuItem result =
          new javax.swing.JMenuItem(
          getSpecializedString(
            name +
            TEXT_SUFFIX,
            specialization));
        initializeJMenuItem(
          result,
          name,
          specialization);
        return result;
    }
    public javax.swing.JRadioButtonMenuItem createJRadioButtonMenuItem(java.lang.String name)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        return createJRadioButtonMenuItem(
                 name,
                 null);
    }
    public javax.swing.JRadioButtonMenuItem createJRadioButtonMenuItem(java.lang.String name,
                                                                       java.lang.String specialization)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        javax.swing.JRadioButtonMenuItem result;
        result =
          new javax.swing.JRadioButtonMenuItem(
            getSpecializedString(
              name +
              TEXT_SUFFIX,
              specialization));
        initializeJMenuItem(
          result,
          name,
          specialization);
        try {
            result.
              setSelected(
                getSpecializedBoolean(
                  name +
                  SELECTED_SUFFIX,
                  specialization));
        }
        catch (java.util.MissingResourceException e) {
            
        }
        return result;
    }
    public javax.swing.JCheckBoxMenuItem createJCheckBoxMenuItem(java.lang.String name)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        return createJCheckBoxMenuItem(
                 name,
                 null);
    }
    public javax.swing.JCheckBoxMenuItem createJCheckBoxMenuItem(java.lang.String name,
                                                                 java.lang.String specialization)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        javax.swing.JCheckBoxMenuItem result;
        result =
          new javax.swing.JCheckBoxMenuItem(
            getSpecializedString(
              name +
              TEXT_SUFFIX,
              specialization));
        initializeJMenuItem(
          result,
          name,
          specialization);
        try {
            result.
              setSelected(
                getSpecializedBoolean(
                  name +
                  SELECTED_SUFFIX,
                  specialization));
        }
        catch (java.util.MissingResourceException e) {
            
        }
        return result;
    }
    protected void initializeJMenuItem(javax.swing.JMenuItem item,
                                       java.lang.String name,
                                       java.lang.String specialization)
          throws org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        try {
            javax.swing.Action a =
              actions.
              getAction(
                getSpecializedString(
                  name +
                  ACTION_SUFFIX,
                  specialization));
            if (a ==
                  null) {
                throw new org.apache.batik.util.gui.resource.MissingListenerException(
                  "",
                  "Action",
                  name +
                  ACTION_SUFFIX);
            }
            item.
              setAction(
                a);
            item.
              setText(
                getSpecializedString(
                  name +
                  TEXT_SUFFIX,
                  specialization));
            if (a instanceof org.apache.batik.util.gui.resource.JComponentModifier) {
                ((org.apache.batik.util.gui.resource.JComponentModifier)
                   a).
                  addJComponent(
                    item);
            }
        }
        catch (java.util.MissingResourceException e) {
            
        }
        try {
            java.lang.String s =
              getSpecializedString(
                name +
                ICON_SUFFIX,
                specialization);
            java.net.URL url =
              actions.
              getClass(
                ).
              getResource(
                s);
            if (url !=
                  null) {
                item.
                  setIcon(
                    new javax.swing.ImageIcon(
                      url));
            }
        }
        catch (java.util.MissingResourceException e) {
            
        }
        try {
            java.lang.String str =
              getSpecializedString(
                name +
                MNEMONIC_SUFFIX,
                specialization);
            if (str.
                  length(
                    ) ==
                  1) {
                item.
                  setMnemonic(
                    str.
                      charAt(
                        0));
            }
            else {
                throw new org.apache.batik.util.resources.ResourceFormatException(
                  "Malformed mnemonic",
                  bundle.
                    getClass(
                      ).
                    getName(
                      ),
                  name +
                  MNEMONIC_SUFFIX);
            }
        }
        catch (java.util.MissingResourceException e) {
            
        }
        try {
            if (!(item instanceof javax.swing.JMenu)) {
                java.lang.String str =
                  getSpecializedString(
                    name +
                    ACCELERATOR_SUFFIX,
                    specialization);
                javax.swing.KeyStroke ks =
                  javax.swing.KeyStroke.
                  getKeyStroke(
                    str);
                if (ks !=
                      null) {
                    item.
                      setAccelerator(
                        ks);
                }
                else {
                    throw new org.apache.batik.util.resources.ResourceFormatException(
                      "Malformed accelerator",
                      bundle.
                        getClass(
                          ).
                        getName(
                          ),
                      name +
                      ACCELERATOR_SUFFIX);
                }
            }
        }
        catch (java.util.MissingResourceException e) {
            
        }
        try {
            item.
              setEnabled(
                getSpecializedBoolean(
                  name +
                  ENABLED_SUFFIX,
                  specialization));
        }
        catch (java.util.MissingResourceException e) {
            
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1Q5Mdm5VoM5mMVyPaN1Dl45d9Sr1mW4t");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("9BGcYpxsJOGmiEvSulNp0Dg0ZWhsPWhVhwsZCvwFri5mHDnsQ6NZLXsqbyHI" +
       "QIa7dQ74Rk1r5UEU3WPQbttYqgq/JrAi8E18xxH4+bI4MNuw38Q65IaQBqKK" +
       "9UJjU+kATgmzvh5juloNNF1MvRFsz7hBBaggNV4oy94mpGtMYIbLsTaqKiNS" +
       "FOoLKSlbwlqfp2mHZ8w6xDZZBDKQGOmEojCoIFTV6PTmLN9QHQ2m9ZW0sseN" +
       "Ym09R5YlbqyqsNZjhEEf1kJXaqtOGW1YASPAOuVBpOvj1DIEazvU7zm1Rbe8" +
       "wfwVvTAqa1ZAy0RP82p834HTBKumiLcUEXgFp/VZWDc2w1gQilhs9adibJiY" +
       "XkcTZDbm5H6HafDOgqNCyeVcbqIKGhGjzRpLL2IXqsjl9rpumD213nFQV4jn" +
       "geFpk6TBNoX6YIgJGhrGsuqZthbPMXi59LjaGkqMYSBiYdzlKByKassV6Xb7" +
       "GyiwUwMdV3iNd3tE2q/VJ22opi8hUV8IE3il1lHSG4xUSazA1KhSpxEJ7lui" +
       "o5uaX+K6narbDkY1FpsknAjr4QosI4g+6U5LQ1uHN5XGIFkpFWMBHsOoKZFs" +
       "vIZBp76C0TFQohI6TJosZ7T7sORo3oKtzpWZANkxNKTsRO/QrGM2J5Y4Lqe9" +
       "0RQVnL6lYBrTpvoxblSqthFKbCfuhL2gt9pMOWuoM3FAVlTbmMMNyVwsK0RU" +
       "XtXmyLSM4/jbsm3Sb59vp/rufAP+MHz3BWy9b289liWvO3yLkf/dXDgV8nns" +
       "LcaxOJ9Ctuv88NWicvMd589/8OlnJv0vIBd28VH/Ni7cGvvBmx1jaTjHmroE" +
       "Wnrj1XfXmTwo+Shu5+sf/O8Pjd4+e+85Yhxfcwrn6SZ/lfnSN9qv13/xQuGG" +
       "wyieK8KlT1Z64mTszm2hESehNzoRwfPwIbOvzBh7HBzv2zH7vtPvh47G7uyX" +
       "Qz+zHftT4Wd7RwXYvMAPTxW4YatHB2+RHj8KA2OsKLK86UFgHLnWjeCQRlC0" +
       "dnZs3EFcXHQYUtfKgi7jK+o/cT3BsVsMWURfFlR02EYuyv/Iku/HhTv10FBj" +
       "o5tF0jZ2gfug/VcefyF24mau/H/6fK8njgew5Rnfu3K0Pr4brY+/NKO1C088" +
       "nKv5kO3dePaQZZf/M0t+nCV/nhe9OTv96RWUZLl/cSj6XuFFiH5flvkGcHxu" +
       "J/rnziM6mOBB6Mf5O/hzMHD3qVLHgir37s2S28FwT42YDww9/67CmByFlrFH" +
       "gt/xIgS/N8uEwPGVneBfOeeY7106h8QPX0Pi12TJg3HhwbMkzqbKidd9J80l" +
       "p65yG/yk/tvD737zs+mXv7R9m6epkREXoKt9ZHPldz5Z4PbrrhF8fvT5xY/b" +
       "b3nuT/6L8J4DK3/7IaV3ZiLdcy1KD+bynccjWvOY4r3XHw3rq17EsN5/MKxf" +
       "22H42ss5rMVrDGsWXbAHxYX7Tg5rwwdPHerWav7R4mjV/lZcuKgdu5cz8aYX" +
       "wUQe4fFmcHx7x8S3X04m3nH9Rg3PkreAGX7MqGXBBb5n7L7xAhpy/wlrf/J2" +
       "Ts0TL4Ka3Pd5NZDyFdu6299zUHOdq/Mec/2sZLGee524cPsxVg7IuPuKpe+I" +
       "B+ql4OGxHQ+PvTQ8nK0i77p+Mt6TJcJJMrKs4ZHc4otd9C4DEd6+k/vtL9P4" +
       "T69fZCtLtLhw6ZjIVGy4Bzpw3xU6cHg35+N5o22vh49dGObeFWGYL6UeJNdP" +
       "yipLgitJybLtI9kXL0L2R7PMtwAxZjvZZy+TLnzg+sX++Sx5f1x4aCc2p04s" +
       "fxsDdlotHj2hFlcrmLP01EvB0vt3LL3/5dSQj18/VX8jSz5yTaqyEr9wRMPz" +
       "Bs1eg4aHs8wKkOgzOxo+8zIpy69cPwOfzZJPxYUHdgw0Z4ZuN/z1aU15+OSK" +
       "elapnJ9ffin4eXbHz7Mvp5r86vWT9GtZ8vmrk5Td/ttHHHzhRXCQe8FvA+L8" +
       "6x0Hf3hODq7idx1Jt2efIuKrV6frGAe/lSXPxoV7Lc+Kt97oyXXklDt649K3" +
       "Jkec/P3zcLIGa/exL2Gzz/oevOK7++234vpvPHPplgeeGf/7/GPQw++5b6UL" +
       "t5iJ4xz/XurY+c1BaJhWTtSt26+n8u/19n43Ljz+/BsRceGWw32NrNZz28pf" +
       "iwuvumrluHADSI8X/zpYlc8sDrjLfo6X/Zdx4a7TZePCTfnv8XL/Ki7cdlQu" +
       "Lty8PTle5I8AElAkO/3mYbgwfL27N4zqAdbD9V5e88HjOpzvo9zzfMN8bDvw" +
       "tSceGPN/v3Cw4ZYMds+lX36my77vR9UvbD+Z1R01TbNWbqELF7df7+aNZpt2" +
       "j121tYO2bu684Sd3Pnvr6w4ePe/cAj6aT8ewvebs71NJN4jzL0rTf/jAP3jr" +
       "333mj/Mg4v8H+P4EKBdDAAA=");
}
