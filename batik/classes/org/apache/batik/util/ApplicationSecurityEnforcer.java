package org.apache.batik.util;
public class ApplicationSecurityEnforcer {
    public static final java.lang.String EXCEPTION_ALIEN_SECURITY_MANAGER =
      ("ApplicationSecurityEnforcer.message.security.exception.alien" +
       ".security.manager");
    public static final java.lang.String EXCEPTION_NO_POLICY_FILE = ("ApplicationSecurityEnforcer.message.null.pointer.exception.n" +
                                                                     "o.policy.file");
    public static final java.lang.String PROPERTY_JAVA_SECURITY_POLICY =
      "java.security.policy";
    public static final java.lang.String JAR_PROTOCOL = "jar:";
    public static final java.lang.String JAR_URL_FILE_SEPARATOR =
      "!/";
    public static final java.lang.String PROPERTY_APP_DEV_BASE = "app.dev.base";
    public static final java.lang.String PROPERTY_APP_JAR_BASE = "app.jar.base";
    public static final java.lang.String APP_MAIN_CLASS_DIR = "classes/";
    protected java.lang.Class appMainClass;
    protected java.lang.String securityPolicy;
    protected java.lang.String appMainClassRelativeURL;
    protected org.apache.batik.util.BatikSecurityManager lastSecurityManagerInstalled;
    public ApplicationSecurityEnforcer(java.lang.Class appMainClass,
                                       java.lang.String securityPolicy,
                                       java.lang.String appJarFile) {
        this(
          appMainClass,
          securityPolicy);
    }
    public ApplicationSecurityEnforcer(java.lang.Class appMainClass,
                                       java.lang.String securityPolicy) {
        super(
          );
        this.
          appMainClass =
          appMainClass;
        this.
          securityPolicy =
          securityPolicy;
        this.
          appMainClassRelativeURL =
          appMainClass.
            getName(
              ).
            replace(
              '.',
              '/') +
          ".class";
    }
    public void enforceSecurity(boolean enforce) { java.lang.SecurityManager sm =
                                                     java.lang.System.
                                                     getSecurityManager(
                                                       );
                                                   if (sm !=
                                                         null &&
                                                         sm !=
                                                         lastSecurityManagerInstalled) {
                                                       throw new java.lang.SecurityException(
                                                         org.apache.batik.util.Messages.
                                                           getString(
                                                             EXCEPTION_ALIEN_SECURITY_MANAGER));
                                                   }
                                                   if (enforce) {
                                                       java.lang.System.
                                                         setSecurityManager(
                                                           null);
                                                       installSecurityManager(
                                                         );
                                                   }
                                                   else {
                                                       if (sm !=
                                                             null) {
                                                           java.lang.System.
                                                             setSecurityManager(
                                                               null);
                                                           lastSecurityManagerInstalled =
                                                             null;
                                                       }
                                                   }
    }
    public java.net.URL getPolicyURL() { java.lang.ClassLoader cl =
                                           appMainClass.
                                           getClassLoader(
                                             );
                                         java.net.URL policyURL =
                                           cl.
                                           getResource(
                                             securityPolicy);
                                         if (policyURL ==
                                               null) {
                                             throw new java.lang.NullPointerException(
                                               org.apache.batik.util.Messages.
                                                 formatMessage(
                                                   EXCEPTION_NO_POLICY_FILE,
                                                   new java.lang.Object[] { securityPolicy }));
                                         }
                                         return policyURL;
    }
    public void installSecurityManager() {
        java.security.Policy policy =
          java.security.Policy.
          getPolicy(
            );
        org.apache.batik.util.BatikSecurityManager securityManager =
          new org.apache.batik.util.BatikSecurityManager(
          );
        java.lang.ClassLoader cl =
          appMainClass.
          getClassLoader(
            );
        java.lang.String securityPolicyProperty =
          java.lang.System.
          getProperty(
            PROPERTY_JAVA_SECURITY_POLICY);
        if (securityPolicyProperty ==
              null ||
              securityPolicyProperty.
              equals(
                "")) {
            java.net.URL policyURL =
              getPolicyURL(
                );
            java.lang.System.
              setProperty(
                PROPERTY_JAVA_SECURITY_POLICY,
                policyURL.
                  toString(
                    ));
        }
        java.net.URL mainClassURL =
          cl.
          getResource(
            appMainClassRelativeURL);
        if (mainClassURL ==
              null) {
            throw new java.lang.Error(
              appMainClassRelativeURL);
        }
        java.lang.String expandedMainClassName =
          mainClassURL.
          toString(
            );
        if (expandedMainClassName.
              startsWith(
                JAR_PROTOCOL)) {
            setJarBase(
              expandedMainClassName);
        }
        else {
            setDevBase(
              expandedMainClassName);
        }
        java.lang.System.
          setSecurityManager(
            securityManager);
        lastSecurityManagerInstalled =
          securityManager;
        policy.
          refresh(
            );
        if (securityPolicyProperty ==
              null ||
              securityPolicyProperty.
              equals(
                "")) {
            java.lang.System.
              setProperty(
                PROPERTY_JAVA_SECURITY_POLICY,
                "");
        }
    }
    private void setJarBase(java.lang.String expandedMainClassName) {
        java.lang.String curAppJarBase =
          java.lang.System.
          getProperty(
            PROPERTY_APP_JAR_BASE);
        if (curAppJarBase ==
              null) {
            expandedMainClassName =
              expandedMainClassName.
                substring(
                  JAR_PROTOCOL.
                    length(
                      ));
            int codeBaseEnd =
              expandedMainClassName.
              indexOf(
                JAR_URL_FILE_SEPARATOR +
                appMainClassRelativeURL);
            if (codeBaseEnd ==
                  -1) {
                throw new java.lang.Error(
                  );
            }
            java.lang.String appCodeBase =
              expandedMainClassName.
              substring(
                0,
                codeBaseEnd);
            codeBaseEnd =
              appCodeBase.
                lastIndexOf(
                  '/');
            if (codeBaseEnd ==
                  -1) {
                appCodeBase =
                  "";
            }
            else {
                appCodeBase =
                  appCodeBase.
                    substring(
                      0,
                      codeBaseEnd);
            }
            java.lang.System.
              setProperty(
                PROPERTY_APP_JAR_BASE,
                appCodeBase);
        }
    }
    private void setDevBase(java.lang.String expandedMainClassName) {
        java.lang.String curAppCodeBase =
          java.lang.System.
          getProperty(
            PROPERTY_APP_DEV_BASE);
        if (curAppCodeBase ==
              null) {
            int codeBaseEnd =
              expandedMainClassName.
              indexOf(
                APP_MAIN_CLASS_DIR +
                appMainClassRelativeURL);
            if (codeBaseEnd ==
                  -1) {
                throw new java.lang.Error(
                  );
            }
            java.lang.String appCodeBase =
              expandedMainClassName.
              substring(
                0,
                codeBaseEnd);
            java.lang.System.
              setProperty(
                PROPERTY_APP_DEV_BASE,
                appCodeBase);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ae3AbxRlfyfEzfsUh78SJHSchDyRCE0riAFEc21GQbdVy" +
       "PESBKOfT2r7kdHe5W9lyIC0w0yFhphkawqNtyF+hoTQQplNKA4Wmw5Q3zPBo" +
       "KTAEBpjhVQoZBtopUPrt7p3udDop2CXVzK1Ou9/ufr9vv/0euzr+MSo1dNSI" +
       "FRIgYxo2Au0KiQq6gZNtsmAYfVCXEG8vET7b/n73Gj8qi6PaYcHoEgUDd0hY" +
       "ThpxNE9SDCIoIja6MU7SHlEdG1gfEYikKnE0TTLCKU2WRIl0qUlMCfoFPYKm" +
       "CITo0kCa4LA5AEHzIsBJkHESDLmbWyOoWlS1MZt8poO8zdFCKVP2XAZB9ZGd" +
       "wogQTBNJDkYkg7RmdLRcU+WxIVklAZwhgZ3yalMEmyOr80TQfH/dF1/ePFzP" +
       "RDBVUBSVMHhGLzZUeQQnI6jOrm2XccrYjX6ISiJosoOYoJaINWkQJg3CpBZa" +
       "mwq4r8FKOtWmMjjEGqlMEylDBDXlDqIJupAyh4kynmGECmJiZ50B7YIsWo4y" +
       "D+Kty4OHbt9e/5sSVBdHdZISo+yIwASBSeIgUJwawLoRSiZxMo6mKLDYMaxL" +
       "giztMVe6wZCGFIGkYfktsdDKtIZ1NqctK1hHwKanRaLqWXiDTKHMX6WDsjAE" +
       "WKfbWDnCDloPAKskYEwfFEDvzC6TdklKkqD57h5ZjC1XAAF0LU9hMqxmp5qk" +
       "CFCBGriKyIIyFIyB6ilDQFqqggLqBM0uOCiVtSaIu4QhnKAa6aKL8iagqmSC" +
       "oF0ImuYmYyPBKs12rZJjfT7uXnfgGmWT4kc+4DmJRZnyPxk6Nbo69eJBrGPY" +
       "B7xj9bLIbcL0R/b5EQLiaS5iTvPgtWfWr2g89SSnmeNB0zOwE4skIR4dqH1h" +
       "btvSNSWUjQpNNSS6+DnI2S6Lmi2tGQ0szPTsiLQxYDWe6n1863X34I/8qCqM" +
       "ykRVTqdAj6aIakqTZKx3YgXrAsHJMKrESrKNtYdRObxHJAXz2p7BQQOTMJok" +
       "s6oylf0GEQ3CEFREVfAuKYOq9a4JZJi9ZzSEUDk8qBqeJYh/2DdByeCwmsJB" +
       "QRQUSVGDUV2l+I0gWJwBkO1wcAC0flfQUNM6qGBQ1YeCAujBMDYbmBBCGjV8" +
       "bHvEsJjWJTLWDpxADz1AtU37P82ToXinjvp8sBRz3YZAhj20SZWTWE+Ih9Ib" +
       "2s/cl3iGKxndGKakCFoJUwf41AE2NV/KIlMjn4/NeB5lgVPDsu0CAwAWuHpp" +
       "7OrNO/Y1l4DGaaOTQOZ+IG3O8URttpWwTHtCPNFQs6fp9MrH/GhSBDUIIkkL" +
       "MnUsIX0ITJa4y9zV1QPgo2xXscDhKqiP01URJ8FSFXIZ5igV6gjWaT1B5zlG" +
       "sBwZ3bLBwm7Ek3906o7R6/t/dKEf+XO9A52yFAwb7R6lNj1ru1vcVsFr3Lob" +
       "3//ixG17Vds+5Lgby0vm9aQYmt064RZPQly2QHgg8cjeFib2SrDfRID9Bqax" +
       "0T1HjvlptUw5xVIBgEE1UoJMmywZV5FhXR21a5iyTmHv54FaTKb7cTE815ob" +
       "lH3T1ukaLWdw5aZ65kLBXMWlMe3Ovz3/wfeYuC2vUucIB2KYtDosGR2sgdms" +
       "Kbba9ukYA90bd0RvufXjG7cxnQWKhV4TttCyDSwYLCGI+cdP7n71zdNHX/Zn" +
       "9dxHwJWnB2DXZLIgaT2qKgISZlts8wOWUAYrQbWmZYsC+ikNSsKAjOnG+qpu" +
       "0coH/n6gnuuBDDWWGq04+wB2/awN6Lpntv+zkQ3jE6kntmVmk3HzPtUeOaTr" +
       "whjlI3P9i/N+9oRwJzgKMM6GtAcze1vCZFACnebZe53up1h6wCC9wihzeQnx" +
       "qiX101vWfNbMPVKjB63DNx54+KF4fEm9yImbvQbO9Yl3H6sQX089/i7vMMuj" +
       "A6ebdnfwJ/2v7HyWaU8FNSm0ngq0xmEwwPQ4VLc+d1Ur4VHNVVW5b9n2P9p8" +
       "aeUlSjCiiiz2glWLpTVN1YnlUs7l8BlYuBk5Rtpesl/vkkOfXPLLS7lQmwrY" +
       "RZv+5A/eeuHOPSeOc02lwiVoeaEAOT8qp4ZrURHja6vH551rT33wTv/VlDG6" +
       "NrW0aOW7byZYA6a9NPDj8RatbmPlKrpd+aal9iVXTfjYG/fX/eHmhpIOsIth" +
       "VJFWpN1pHE46nScEnEZ6wKE3diTIKpxK8w18fPD8hz5UWWgFV5qGNjMqWpAN" +
       "izQtQ9sJ8i2DVwtOvQ2Hx7G0/go2y2pGc2EWG2LYuFC6abHIcHqbXJk6UpSE" +
       "ePPLn9b0f/roGbZ2uTmO07h2CVort+e0WMy0xx0NbBKMYaBbdar7qnr51Jcw" +
       "YhxGFEE1jR4dopJMjik2qUvLX/vTY9N3vFCC/B2oSlaFZIfAvBqqBHeCjWEI" +
       "aDLa5ev5vhutgKKeQUV54PMqqEWb720r21MaYdZtz+9n/HbdsSOnmVnX2BDz" +
       "8l3WfnPf7/d2WbRcQovl+Y6gUFfXCvp56ER/rrXXeXuRdd5Bi62sqYcWcS6A" +
       "3gnKilZcaSrfHFZZTYPMHBPBjgrsUOKel77/l2M/vW2U24mlhbewq9/Mf/fI" +
       "Aze8/a88nWORk0ci5OofDx4/PLvtso9YfzuEob1bMvmBMYSBdt+L7kl97m8u" +
       "+7MflcdRvWim5v2CnKaBQRzSUcPK1yF9z2nPTS15HtWaDdHmusMnx7Tu4Mlp" +
       "UyaRHPthx0sz6brE4QmYGnSBW/l8EIF0FUsZUrD1IGkNGGYDrIyINUoaAJ+A" +
       "FbshJShAyEQoc3Vm5TJaXMA9PX0NQMhjsPMEAogkRZBdoc8Mi08PfiF4b7+y" +
       "rT3aF+7pToQi4fbuRKy9bUtvuG9roivUHeps72Wab+8ppteps+n1YK7I+uFZ" +
       "bbKwyktk4W8jMiUtywFNZYcTDrEpKlRC57GAlZWOFhMXLXbTQveQ06oCTEIO" +
       "bsupuycR7YmE27YmOsKRdi/5ZMYpnyZ4Ws2p13rJh6d5WdXgeGnzdROGurbA" +
       "fATNi/b2RNt7QQU2h/pDtkJw0F54rx8n3inwhMz513vhnbRT0JnN3T9hfOsL" +
       "jE9Q9eZQbwIw9vW09US84Nw0Tjh18Gwyp+v0guNvCtIfBycMprPA6JA6UDBb" +
       "eiNMF2GtoqHeUF+P5669ZZywZsHTbU7c5QWrWtC0QBKPBGh8Sat/MWGAXQXm" +
       "IWhaVhtD0WhiY3t/YkMo5rnrDk8AX585b6wgPtDELL6jE8YXKzCPGx9dzUL4" +
       "7honvmnwbDPnjXvhq2CH3uAXadW9E8YWLzAHOGcKqSsU7k60RUKxWGJj2FMx" +
       "7/v2wGppLTWXO8xJd+QBQ+zld95wAHWlpqsE4gScdGGpKTIsV4YuCGqyacxa" +
       "F4oHx4miBR5sTocLoPijHceezGe2UG+Cai1XEc16CrfQT42TXRo67DQn3FmA" +
       "3ceLsluoN0EznLLtxTLEASMYjJoX30+Mk29KlnNG4MH3c0X5LtQbAkzgl1jx" +
       "SheP11iACVlN0soZl3kf7m6gr66+LqjPF4Ga8cpw2KcMuQ7cHSw7UglEE8Z5" +
       "he5E2H3O0RsOHUn23LWSJxMNufcM7Uo6de9fv342cMdbT3kcaVcSVbtAxiNY" +
       "dsxZmns0BelLF7susnOBN2oPvnOyZWjDeE6gaV3jWc6Y6e/5AGJZ4YzIzcoT" +
       "N3w4u++y4R3jOEye7xKne8hfdR1/qnOxeNDP7sZ4kpJ3p5bbqTU3NanSMUnr" +
       "Su4Bx8Lc7PhCeA6bCnDYrfG2ihXKjgt1deW99tmN15lgVJdSEt3F/CTnougO" +
       "cV9L9F3rlGgNLTZRDSySorrGCO5teHPX4ffvNU8t847Vc4jxvkM3fRM4cIhr" +
       "Jr+9XJh3gejsw28w+YFRlrumYrOwHh3vndj78N17b7SQvUZQ+YCqylhQ3KKi" +
       "PzszjOq9IocIn9HibYLqME+ALBvBiD80WaNf/4A4eUSVkrbBeOe7OG9g9aez" +
       "ekGDWzQHnodMvXho/CpVqGthKfh8RdpYTPIVuOQhTLiDA19hmdtqliopmASs" +
       "Siaar8+BaNhuOx+ep018T49fNIW6FoFfX6StgRaTIS2QuBvycDCfZ4Xiqz4H" +
       "QqH3vWgNqHspH5N/FxCKR3hWrunSiECwKzibXGREb8tEf7IjO9/8IgJrogWo" +
       "TZWByWZB32BG+g4hzTqXQlphQlpRXHN8c/KlUajr2aSxoog0aKDvW8KlsRGP" +
       "eEjj/O/kSJOgOUVOfOgh8cy8/9Tw/4GI9x2pq5hxZMsrLELI/lejGnz9YFqW" +
       "nad4jvcyTceDEhNqNT/T0xjeiyH/8gzPwLTSLwrAt5rTriGo3k1LUCn7dtKt" +
       "A/HZdASV8RcnyeUElQAJfV2vWYbLcbfADzIzvtxwLWvLpp1tDRwR3sIc/8r+" +
       "z2T56nTUvCw6cWRz9zVnLr6L3+NCUrhnDx1lcgSV8yvlbIDTVHA0a6yyTUu/" +
       "rL2/cpHlD6dwhm11nuNwdVeCYmp0tWe7LjmNluxd56tH1z363L6yF8GTb0M+" +
       "gaCp2/KPfDNaGiLLbZH8WyQIBtnta+vSn49dtmLwk9fZrQLikcvcwvQJ8eVj" +
       "V790cObRRj+aHEal4Opxhp1FbxxTerE4osdRjWS0Z4BFGEUS5JwrqlqqmAK9" +
       "IcrmiyDOmmwt/RcAQc35EUn+fyeqZHUU6xvUtJKkw9RAMGrXWIFuToyY1jRX" +
       "B7vGXEpaduxmsQRdDdDHRKRL06wrMXRSY1u10zuGoYobY6/0re+/uA0X+uso" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3qqzrW2/Q8oGzFXnOh4hECPMerxOuixr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("aFRH3Y5oLA1SvbqWgkbXSn02X3ZnWgz2mUtzbebr0aBjjxfjdhc2h4YoLqo6" +
       "ReheYxhtnKjWNzYb2QYuNUwscaFKsNbA+iShSM1BHq+81cpHmS5txr677Q19" +
       "P08h0URHZr1JKEF1trVXGqUorc1aSQfMMu+KKEfGE5XuZ3K4nYLAaIK11+SE" +
       "iHQr2/jJSLR6Vo8SGZGFW3nMTURpWstq8C4jw2loTFsQHNtVKEPhSTVLQhRF" +
       "f6w4kvqDOzsVfLg87Dy+Jvo9HHNuzrstUf7dWzlztfDUqfKpiweV4oTvmVvd" +
       "/ixP9z73kVdfs4a/Uju6V/Nv08oDaRi917PXtneqq+Km84u3PsnkysuvJxcJ" +
       "fucj//0p+f3Oy3dwhe4dZ/g82+U/5F7/XfLd5i9erNx1fK3gpmu5Nza6duNl" +
       "gkuxnWZxIN9wpeCZG6+wwCB95lCynznvs8qV2xzWv2c/92fulFzYE5TvXzo1" +
       "519OK/cZYejZelC2+/pt7qJ8o8j+OK1ctvef348O88/r9O516FonGvYnd3Jt" +
       "pSz42rFIii+2lbeB9MVDkXzxByOS09D+4jZ1f1lk30orD87tdP/hSBHZo48d" +
       "D5bn+YGdHhwVlni//X3gLVXgPSD93iHe3/uB471w/23qLhXZXWnlcXf/Zeec" +
       "bzb/8xjphbu/D6TF5eRKFzB9z77t/vfNIgWaG8XuWk/t22l8ae9KXI/dBvMT" +
       "RXY5rVxK7HSgx9jh1+hTOK/8IHC+dIjzpTuc0QuPvjmIz90G4vNF9vQeYs9e" +
       "nwPxmTu6W5ZW3nabmznFdc8nb/rHjP0/E5i/9trl+594TfkP5SXh4wv/D7CV" +
       "+2eZ552+eXXq+d4otmduKYcH9vewohLXi2nlsXO/OAIjVPwUnF94YU/73rRy" +
       "5SxtWrmn/D1NBwMxndCllXv3D6dJ6mnlLkBSPDaiI2tw6uve/vLZ5sKNnvDY" +
       "QDzy3WR9ynk+f4PLK/8p5sg9ZcLhHdgvvDbgf/KbrV/Z3182PX23K3q5n63c" +
       "t79Kfezinrtlb0d93Uu98J2Hfv2Bdx2544f2DJ/o6Cne3nH+ZWHCj9Lyeu/u" +
       "nz3xT37077/2R+Xnzf8HuQ7pqa00AAA=");
}
