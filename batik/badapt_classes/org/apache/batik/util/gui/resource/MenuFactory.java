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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "iG+/01Ud13KP4Jp2TdiWNN9OP3H46PH04D0XmAu+Fu82b1LJZh78yT+/F7vj" +
       "uW8H7CsuZqp2nkxnqexbYq7xLDH7+W69s177VeOtv/lC53RPOTuBmNc+z14f" +
       "/j4LQGwKX7X6q/Lo4d+vGt06c3UZm3pn+ej0F3l//8lvbz9bvDXKjybMhWTB" +
       "kYZXqcu7fKzXKcvqyqhnEbk+7wDcCTrgudZygGv93uy4mM938ttVYapc0tmC" +
       "iTgddzcv9UWfQJUZoWyf73A2JvolwwDPtzeHkjmRanlmQfSi4P0he2/IyG8r" +
       "9eLGIyvQ7yplT9usA26J4EFEvgwO5SVMnoeYL+oUVtI7cQO8x/IqKP8Md/f1" +
       "fOTd9rfzRZ/imziYkTRDxXOFDXuz1To3l9+wYaq+drN28/Ijgtm6/wpuXfz5" +
       "B0z+iMmrKBrhZf+tgD3Mfd1h6e8LwFIrftsIz90W1LuLsFQwBkHQ0nSV8bmR" +
       "byhqKFJmKfRFGnxSrg3MSBMmNeBW05SNaFTkx6407Wyy7M6zFqldANaW47fN" +
       "8HzaQvjp4r4VWVxITphqSeSsKkLOakxaGVkZRA72Xu+QgmPFSHbSYMPCHB/M" +
       "JsS95zS3dV7yeoc5irUHyLoOYm/60hfHx89pFk3hjqCCvQew991bJ/4i863n" +
       "TYUzAxRMudb74h8Y++k13+OjSR0OX/kY7hq6YJizBhNMm/M8NyIfLfDcb/HM" +
       "/zKy9788YwS1TJxJGeAyPiplaBpvNyAG6wxzQcvnm+qe2YDTaB/fJ3e/cvHH" +
       "LjVpXRcyajvyX7jiuSfuOnjqpDkTQXoZ2Rx2H6PwEggemG0ocujnOMiftr/9" +
       "9Iu/Gbsyap0+NKJ/rs/ZQ0Oj+5CAH9NENvuHTDzW8vqJWfS29zV9+ZaWql6Y" +
       "+/SRuqwi7c/SvrR3/K81spMux3HuHTizActr/g3/IvD8Cx/0FswwvaYlYZ3B" +
       "r80fwmtaDr8zEtlknwrweNO2APGmzY4337Cc+Rvlx5sw1ZLizZYi8WYrJhcx" +
       "0uqNNz2qKlNBMYJjwpAOLs6kWash3zx0tXikc+h5y0ci6zA5H929yKGJr4z4" +
       "oZZn9x174UErahUc5nqE6ZGj7/937KajpvebV2XWF9xWceuY12VMf8nXbl0x" +
       "K1yj93enDn3pvkM32t7/S1iHTVrU+LwcS427POniBfAkvoo+D56nLXd4unxP" +
       "ClMtyZNGSp8V4alNZABGedesCPuhqlDrGhiEjzbPzNL7mbM4uAAsLsNvq6HJ" +
       "Gswyzb/hLAbMLUNV51k0RCZLJxB3diJXwoLaRaDN27KCGblD2VULSdk6C/e6" +
       "8ikLUy3J8faXzhvKRGQvb5g15VCUWai5eCfg22rh3Fo+RWGq83nVu0tn53pM" +
       "DjDS5GKnj1lXPMGzWgs8K/+VU3dwIamztvojBecJ81MXplqSd32gdP5uxuRI" +
       "IX+Yfdihad7TlApoWovf3g4YZyysM+XTFKY6n4fdWTpDxzC5jZFVFkPDQlpS" +
       "zU0/v7Ot9ThbmCAn9PaFJPQ6i5Xryic0TLUkv7u/dFY/jsmJoqyixHGHsXsW" +
       "gLE1+A3EIscs2MfKZyxMdT4X/GzpZH0ek08yssIiKzFDxX09as7vf2u8048g" +
       "KU7lpxaSyocsPh4qn8ow1ZKc75ul8/koJqfD+cTPX3To+toC0MV3BC4FrD+w" +
       "MD9enK6Aqa+pEqAaSkTksI+zJ8OZddH1FCbfZ2S5pMBygi+oPCNppGe/uQTB" +
       "P72MLJpVpbRD3+P/C/pyMAFy3WPGq3IrC/7XhHnTX/zE8aa6Fcd3/ZQfQuRv" +
       "4y9NkbqprCy7L3O53ms0nU5JnPWl5tUufnUx8iwjHfPvRzNSl9/eRq1nTOVf" +
       "M3JmqDIjVZC6xX8L85VAceAU/7hlX2Ck2S/LSDX/65Z7iZF6R46RGvPFLfJH" +
       "qAmI4Osr+TOueKmb+P2CAqzrOT5RdQ6n7OYnrfM1v+s8a71nfc3/84y9Vs8O" +
       "WVtFp47vHLj2tbfdY94eFmXh4EEsZUmK1JoXmXmhVQXbTu7S7LJqdmx8o/Gh" +
       "xRvs9fAys8JO17Prxp0QupqGjrfKd7XW6MzfsP35iS2PfP9IzZOwkt9DIgL0" +
       "mT2FlxBzWlYna/akCjeRxgSd3/nt2njnga3nTr3yC37Nk5ibTqvD5SfEp+69" +
       "8ke3rjzRHiVL+kg1LPVpjt+O3HZAGabirD5OGiQjmePHJdiHPTtUjdhHBNyR" +
       "5bxYdDbkc/HuOXSDwh2Jwhv79bI6R/UeNavwk/yGFFni5Jgt4zsRy2qaT8HJ" +
       "sZoSPTNmxhhsDXDXiVS/ptk7YlUbNIwSkXjAYBuJo3Y0yl/xreo/Bcc0g1g3" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18CbArWXme3pt9Yd4szDBMGJgZBmIQvJbULanFsFhqtVot" +
       "qVstqbU14KFX9b5vapgEcDlQUAXEHjCJgVQFqMQYG2JCOU7KqXFCgokdx6TI" +
       "RlUMlaQqOJgKJIWdMknI6Zbu+u578+4suVV91H36LN//nf/85+/Tf98v/qB0" +
       "U+CXyq5jbjemE16W0/CybtYvh1tXDi4PRnWG9wNZwkw+CFiQ96T42Jcv/dlP" +
       "PqbefbF0M1e6j7dtJ+RDzbGDqRw4ZixLo9Klo1zclK0gLN090vmYh6JQM6GR" +
       "FoRPjEp3HKsalh4fHUCAAAQIQIAKCFD7qBSo9BLZjiwsr8HbYeCV/krpwqh0" +
       "syvm8MLSoycbcXmft/bNMIUEoIVb8+sFEKqonPqlRw5l38l8hcAfL0NP//LP" +
       "3f2bN5QucaVLmj3L4YgARAg64Up3WrIlyH7QliRZ4kr32LIszWRf400tK3Bz" +
       "pXsDbWPzYeTLhyTlmZEr+0WfR8zdKeay+ZEYOv6heIomm9LB1U2KyW+ArA8c" +
       "ybqTsJfnAwFv1wAwX+FF+aDKjYZmS2HpVadrHMr4+BAUAFVvseRQdQ67utHm" +
       "QUbp3t3Ymby9gWahr9kbUPQmJwK9hKWHrtpozrXLiwa/kZ8MSw+eLsfsboFS" +
       "txVE5FXC0v2nixUtgVF66NQoHRufH9Bv/si77b59scAsyaKZ478VVHrlqUpT" +
       "WZF92RblXcU7Xz/6BP/A73zwYqkECt9/qvCuzG+950c/+4ZXPvN7uzJ/6Ywy" +
       "Y0GXxfBJ8XPCXd98Bfa61g05jFtdJ9DywT8heaH+zP7OE6kLZt4Dhy3mNy8f" +
       "3Hxm+s/X7/2C/P2LpdvJ0s2iY0YW0KN7RMdyNVP2CdmWfT6UJbJ0m2xLWHGf" +
       "LN0CzkeaLe9yx4oSyCFZutEssm52imtAkQKayCm6BZxrtuIcnLt8qBbnqVsq" +
       "lW4BR+lOcBCl3V/xG5Z4SHUsGeJF3tZsB2J8J5c/gGQ7FAC3KiQArTegwIl8" +
       "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" +
       "UQfo3lBs1iMThQxn4CndssgyK5h1yqGD");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "iP8fRQDPZRdDAAA=");
}
