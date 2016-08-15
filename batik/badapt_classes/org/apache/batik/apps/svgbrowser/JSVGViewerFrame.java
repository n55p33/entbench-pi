package org.apache.batik.apps.svgbrowser;
public class JSVGViewerFrame extends javax.swing.JFrame implements org.apache.batik.util.gui.resource.ActionMap, org.apache.batik.swing.svg.SVGDocumentLoaderListener, org.apache.batik.swing.svg.GVTTreeBuilderListener, org.apache.batik.swing.svg.SVGLoadEventDispatcherListener, org.apache.batik.swing.gvt.GVTTreeRendererListener, org.apache.batik.swing.svg.LinkActivationListener, org.apache.batik.bridge.UpdateManagerListener {
    private static java.lang.String EOL;
    static { try { EOL = java.lang.System.getProperty("line.separator", "\n");
             }
             catch (java.lang.SecurityException e) {
                 EOL =
                   "\n";
             } }
    protected static boolean priorJDK1_4 = true;
    protected static final java.lang.String JDK_1_4_PRESENCE_TEST_CLASS =
      "java.util.logging.LoggingPermission";
    static { try { java.lang.Class.forName(JDK_1_4_PRESENCE_TEST_CLASS);
                   priorJDK1_4 = false; }
             catch (java.lang.ClassNotFoundException e) {  } }
    public static final java.lang.String RESOURCES = "org.apache.batik.apps.svgbrowser.resources.GUI";
    public static final java.lang.String ABOUT_ACTION = "AboutAction";
    public static final java.lang.String OPEN_ACTION = "OpenAction";
    public static final java.lang.String OPEN_LOCATION_ACTION = "OpenLocationAction";
    public static final java.lang.String NEW_WINDOW_ACTION = "NewWindowAction";
    public static final java.lang.String RELOAD_ACTION = "ReloadAction";
    public static final java.lang.String SAVE_AS_ACTION = "SaveAsAction";
    public static final java.lang.String BACK_ACTION = "BackAction";
    public static final java.lang.String FORWARD_ACTION = "ForwardAction";
    public static final java.lang.String FULL_SCREEN_ACTION = "FullScreenAction";
    public static final java.lang.String PRINT_ACTION = "PrintAction";
    public static final java.lang.String EXPORT_AS_JPG_ACTION = "ExportAsJPGAction";
    public static final java.lang.String EXPORT_AS_PNG_ACTION = "ExportAsPNGAction";
    public static final java.lang.String EXPORT_AS_TIFF_ACTION = "ExportAsTIFFAction";
    public static final java.lang.String PREFERENCES_ACTION = "PreferencesAction";
    public static final java.lang.String CLOSE_ACTION = "CloseAction";
    public static final java.lang.String VIEW_SOURCE_ACTION = "ViewSourceAction";
    public static final java.lang.String EXIT_ACTION = "ExitAction";
    public static final java.lang.String RESET_TRANSFORM_ACTION = "ResetTransformAction";
    public static final java.lang.String ZOOM_IN_ACTION = "ZoomInAction";
    public static final java.lang.String ZOOM_OUT_ACTION = "ZoomOutAction";
    public static final java.lang.String PREVIOUS_TRANSFORM_ACTION = "PreviousTransformAction";
    public static final java.lang.String NEXT_TRANSFORM_ACTION = "NextTransformAction";
    public static final java.lang.String USE_STYLESHEET_ACTION = "UseStylesheetAction";
    public static final java.lang.String PLAY_ACTION = "PlayAction";
    public static final java.lang.String PAUSE_ACTION = "PauseAction";
    public static final java.lang.String STOP_ACTION = "StopAction";
    public static final java.lang.String MONITOR_ACTION = "MonitorAction";
    public static final java.lang.String DOM_VIEWER_ACTION = "DOMViewerAction";
    public static final java.lang.String SET_TRANSFORM_ACTION = "SetTransformAction";
    public static final java.lang.String FIND_DIALOG_ACTION = "FindDialogAction";
    public static final java.lang.String THUMBNAIL_DIALOG_ACTION = "ThumbnailDialogAction";
    public static final java.lang.String FLUSH_ACTION = "FlushAction";
    public static final java.lang.String TOGGLE_DEBUGGER_ACTION = "ToggleDebuggerAction";
    public static final java.awt.Cursor WAIT_CURSOR = new java.awt.Cursor(
      java.awt.Cursor.
        WAIT_CURSOR);
    public static final java.awt.Cursor DEFAULT_CURSOR = new java.awt.Cursor(
      java.awt.Cursor.
        DEFAULT_CURSOR);
    public static final java.lang.String PROPERTY_OS_NAME = org.apache.batik.apps.svgbrowser.Resources.
      getString(
        "JSVGViewerFrame.property.os.name");
    public static final java.lang.String PROPERTY_OS_NAME_DEFAULT =
      org.apache.batik.apps.svgbrowser.Resources.
      getString(
        "JSVGViewerFrame.property.os.name.default");
    public static final java.lang.String PROPERTY_OS_WINDOWS_PREFIX =
      org.apache.batik.apps.svgbrowser.Resources.
      getString(
        "JSVGViewerFrame.property.os.windows.prefix");
    protected static final java.lang.String OPEN_TITLE = "Open.title";
    protected static java.util.Vector handlers;
    protected static org.apache.batik.apps.svgbrowser.SquiggleInputHandler
      defaultHandler =
      new org.apache.batik.apps.svgbrowser.SVGInputHandler(
      );
    protected static java.util.ResourceBundle bundle;
    protected static org.apache.batik.util.resources.ResourceManager
      resources;
    static { bundle = java.util.ResourceBundle.getBundle(RESOURCES,
                                                         java.util.Locale.
                                                           getDefault(
                                                             ));
             resources = new org.apache.batik.util.resources.ResourceManager(
                           bundle); }
    protected org.apache.batik.apps.svgbrowser.Application application;
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.Canvas
      svgCanvas;
    protected class Canvas extends org.apache.batik.swing.JSVGCanvas {
        public Canvas(org.apache.batik.swing.svg.SVGUserAgent ua,
                      boolean eventsEnabled,
                      boolean selectableText) { super(ua, eventsEnabled,
                                                      selectableText);
        }
        public java.lang.Object getRhinoInterpreter() { if (bridgeContext ==
                                                              null) {
                                                            return null;
                                                        }
                                                        return bridgeContext.
                                                          getInterpreter(
                                                            "text/ecmascript");
        }
        protected class JSVGViewerDOMViewerController implements org.apache.batik.apps.svgbrowser.DOMViewerController {
            public boolean canEdit() { return getUpdateManager() !=
                                         null; }
            public org.apache.batik.apps.svgbrowser.ElementOverlayManager createSelectionManager() {
                if (canEdit(
                      )) {
                    return new org.apache.batik.apps.svgbrowser.ElementOverlayManager(
                      Canvas.this);
                }
                return null;
            }
            public org.w3c.dom.Document getDocument() {
                return Canvas.this.
                         svgDocument;
            }
            public void performUpdate(java.lang.Runnable r) {
                if (canEdit(
                      )) {
                    getUpdateManager(
                      ).
                      getUpdateRunnableQueue(
                        ).
                      invokeLater(
                        r);
                }
                else {
                    r.
                      run(
                        );
                }
            }
            public void removeSelectionOverlay(org.apache.batik.swing.gvt.Overlay selectionOverlay) {
                getOverlays(
                  ).
                  remove(
                    selectionOverlay);
            }
            public void selectNode(org.w3c.dom.Node node) {
                org.apache.batik.apps.svgbrowser.JSVGViewerFrame.DOMViewerAction dViewerAction =
                  (org.apache.batik.apps.svgbrowser.JSVGViewerFrame.DOMViewerAction)
                    getAction(
                      DOM_VIEWER_ACTION);
                dViewerAction.
                  openDOMViewer(
                    );
                domViewer.
                  selectNode(
                    node);
            }
            public JSVGViewerDOMViewerController() {
                super(
                  );
            }
            public static final java.lang.String
              jlc$CompilerVersion$jl7 =
              "2.7.0";
            public static final long jlc$SourceLastModified$jl7 =
              1471028785000L;
            public static final java.lang.String
              jlc$ClassType$jl7 =
              ("H4sIAAAAAAAAAL1Ze2wUxxmfOz/wEz/AhvAwYAyqCbkLBZJGpknA2GByfsg2" +
               "VmoSjrm9ufPivd1ld84+O6V5KC20UikiJJCqQa0ESlIlAVWJmqpNRBq1ISJN" +
               "lRQ1TauQqqlU+kANqpT+Qdv0+2Z3b/f2fGc5KrV0c3Mz38z3fb/5XjN+7iop" +
               "Mw3SwlQe4lM6M0NdKh+ghsninQo1zWEYi0onSug/9l7puyNIykfJ/DFq9krU" +
               "ZN0yU+LmKFkuqyanqsTMPsbiuGLAYCYzJiiXNXWUNMlmT0pXZEnmvVqcIcEI" +
               "NSKkgXJuyLE0Zz32Bpwsj4AkYSFJeKt/uiNCaiRNn3LJF3vIOz0zSJlyeZmc" +
               "1Ef20wkaTnNZCUdkk3dkDHKzrilTSUXjIZbhof3KZhuCXZHNeRC0nqv75PrR" +
               "sXoBwQKqqhoX6pmDzNSUCRaPkDp3tEthKfMA+QopiZBqDzEnbRGHaRiYhoGp" +
               "o61LBdLXMjWd6tSEOtzZqVyXUCBOVuVuolODpuxtBoTMsEMFt3UXi0HblVlt" +
               "LS3zVHz85vDxE3vrf1BC6kZJnawOoTgSCMGBySgAylIxZphb43EWHyUNKhz2" +
               "EDNkqsjT9kk3mnJSpTwNx+/AgoNpnRmCp4sVnCPoZqQlrhlZ9RLCoOxfZQmF" +
               "JkHXZldXS8NuHAcFq2QQzEhQsDt7Sem4rMY5WeFfkdWx7R4ggKXzUoyPaVlW" +
               "pSqFAdJomYhC1WR4CExPTQJpmQYGaHCypOCmiLVOpXGaZFG0SB/dgDUFVJUC" +
               "CFzCSZOfTOwEp7TEd0qe87nat+XIA+pONUgCIHOcSQrKXw2LWnyLBlmCGQz8" +
               "wFpYsy7yBG1+5XCQECBu8hFbND/88rW717ecv2DRLJ2Bpj+2n0k8Kp2OzX9n" +
               "WWf7HSUoRoWumTIefo7mwssG7JmOjA4Rpjm7I06GnMnzgz//0kPfZ38Nkqoe" +
               "Ui5pSjoFdtQgaSldVpixg6nMoJzFe0glU+OdYr6HzIN+RFaZNdqfSJiM95BS" +
               "RQyVa+I3QJSALRCiKujLakJz+jrlY6Kf0QkhjfAhIUICg0T8BQaw5UQKj2kp" +
               "FqYSVWVVCw8YGupvhiHixADbsXAMrH48bGppA0wwrBnJMAU7GGP2BNV1M2xO" +
               "JGOGNgnRMLxraGTHiMwmmdEN7spCaGz6/4dNBrVdMBkIwEEs84cBBTxop6bE" +
               "mRGVjqe3dV17IXrRMjF0CxsnTnYD55DFOSQ4h5BzyOUc8nFu66TqBDXb3OHt" +
               "/b1WB2OKoSlwwCQQEFItRDEt04CDHYcQATG6pn3o/l37DreWgE3qk6V4NkDa" +
               "mpOrOt044gT/qHS2sXZ61eUNrwdJaYQ0UomnqYKpZ6uRhKAmjdt+XxODLOYm" +
               "k5WeZIJZ0NAkFodYViip2LtUaBPMwHFOFnp2cFIdOnW4cKKZUX5y/uTkwyMP" +
               "3hokwdz8gSzLIPTh8gGM+tno3uaPGzPtW3foyidnnziouREkJyE5eTRvJerQ" +
               "6rcbPzxRad1K+lL0lYNtAvZKiPCcgkdC8Gzx88gJUB1OsEddKkDhhGakqIJT" +
               "DsZVfAyMzB0RBt2ATZNl22hCPgFFnvjikP7Ub97+80aBpJNS6jy1wBDjHZ4w" +
               "hps1ioDV4FrksMEY0H1wcuCxx68e2iPMEShWz8SwDdtOCF9wOoDgVy8ceP/D" +
               "y6cvBV0T5qRSNzQOTs7iGaHOwk/hLwCf/+AHow8OWFGosdMOhSuzsVBH5mtd" +
               "8TrRkyRhH227VbBEOSHTmMLQhf5Vt2bDS387Um+duAIjjsGsn30Dd/ymbeSh" +
               "i3v/2SK2CUiYlV0IXTIr1C9wd95qGHQK5cg8/O7yJ9+gT0HSgEBtytNMxF4i" +
               "ICHiDDcLLG4V7Sbf3O3YrDG9Zp7rSZ7qKSodvfRx7cjHr14T0uaWX96j76V6" +
               "h2VI1ikAszCxmmwuEN8426xjuygDMizyx6qd1ByDzTad77uvXjl/HdiOAlsJ" +
               "wrXZb0BczeRYk01dNu+3r73evO+dEhLsJlWKRuPdVPgcqQRjZ+YYhOSMftfd" +
               "liCTFdDUCzxIHkJ5A3gKK2Y+366UzsWJTL+86MUtT5+6LCxTt/ZY6t1wrWjb" +
               "sVlvWS52b8lkwUKRSIOTMJ1vD1iePQOiv5iTTbOmkRmyBKK+vFBhJIq6048c" +
               "PxXvP7PBKl8ac4uNLqiln//1v98Knfz9mzNktnK7sHWlLUd+OWmmVxSMbqj7" +
               "YP6xj37Ultw2lwyDYy2z5BD8vQI0WFc4Y/hFeeORvywZvnNs3xySxQoflv4t" +
               "n+197s0da6VjQVEdW3kir6rOXdThRRWYGgyuASqqiSO1ws9WZ01nKVpKK5jF" +
               "sG06w34/s6L6zHYIR6anY3ChdG2xhliVXMENiwSX0SJz92EzxMk8KM+64jLP" +
               "rT/wxIfSMRNqBTkF+WPCLrg/P7BPOtw28EfLGm+aYYFF1/RM+Jsj7+1/Sxxd" +
               "BdpKFjCPnYBNebJePTYh9Ij2ItfXXHnCBxs/HP/Olectefy3BR8xO3z8G5+G" +
               "jhy3PMW6Uq3Ou9V411jXKp90q4pxESu6/3T24I+fOXgoaGN9D8Ac0zSFUTV7" +
               "FoFs2bcwF0VL1u1fr/vJ0caSbnDDHlKRVuUDadYTzzXFeWY65oHVvYW5hmlL" +
               "jVmXk8A6Jxx+AZthq7/lM0ZiHNimi/H+rLW249xdoNe9trXeW8T8sRnJN/RC" +
               "S4sYc7rI3CQ2EAybJYNBkTHE7IzRS1W4vRpO+L5t1vCNTx9wVP0Q0BQ65V0u" +
               "4DxwA+D8HM5tBCyiNibRucNZaGkRyB4tMvc1bB7kpDrJ+HZNSiMkDoYLEcPJ" +
               "jVIorqVCOZMCoYduAEILcG4DqCfZakpzR6jQUh8Kgdx83yjKEHxTCQ2mVRXL" +
               "SsHrsSLgncDmCCe14Kh4F9itx8EkBSm14wt+wYWrdEKT4y5037pR0O0EjcZt" +
               "/cfnDl2hpcWha83zNXNSBhyTEzxku5fgfaYIlM9i811wa4OloMbIurW9Hmef" +
               "dPH73o3C7xZQS7NB0OaOX6GlxfGr9/pZH+QMwenFImi9jM1ZTqpMgVOfXZB5" +
               "EDr3v0Aow8nyoq8ijga3f8Y3F0iXi/Nee60XSumFU3UVi07tfk9UrtlXxBqo" +
               "PxJpRfHkTW8OLdcNlpAFRjXWlUkXXz/lZOVsMiKc2R9Cs9esxT/jpGnGxeDX" +
               "+OWlvWAfp5eWkzLx7aW7CNxcOigUrY6X5G1OSoAEu7/Us7bihinrnTMTyL8R" +
               "CQtoms0Csku8LwRYoYlneqeESVsP9VHp7KldfQ9cu+2M9UIhKXR6GnephsLF" +
               "egfJVu2rCu7m7FW+s/36/HOVa5yKKueFxCubsENwFfGUsMR3Xzfbstf2909v" +
               "efUXh8vfhVpwDwlQThbs8TySW0jBpT8N16U9kfwCDW444iGho/3bU3euT/z9" +
               "d+KySayCbllh+qh06en7f3Vs8emWIKnuIWVQLLLMKKmSze1T6iCTJoxRUiub" +
               "XRkQEXaRqZJT/c1Hq6b4gC9wseGszY7i0xWE1/yaNv/BDy7m4FvbtLQax22g" +
               "fqx2R3L+f2B7SlVa130L3BFPGS9biQxPA+wxGunVdefRp6RLF4Fivz+wiUGx" +
               "+g+ii81H/wWg0dJcwhsAAA==");
            public static final java.lang.String
              jlc$CompilerVersion$jl5 =
              "2.7.0";
            public static final long jlc$SourceLastModified$jl5 =
              1471028785000L;
            public static final java.lang.String
              jlc$ClassType$jl5 =
              ("H4sIAAAAAAAAAL1ae6wjV3mf3SSbZEmymw0JaSBPFkowvTP22B5by8sz9vg1" +
               "D3tmPH6Usozn4RnP0/PwjIemDUg0qEgBlYRSCSJVAtGi8BAqbSVKlaoPQNCq" +
               "tIgWpAKqKpWWopI/SqvSlp4Z33t9793NRmmgV7rHx+d83znf8zffnOOnvw/d" +
               "EPhQwXOtzcJywz01CfeWVmUv3HhqsNejKgPJD1SFsKQgEMDYZfmhT5/74Y/e" +
               "p58/DZ2ZQXdIjuOGUmi4TsCpgWutVYWCzu1GW5ZqByF0nlpKawmOQsOCKSMI" +
               "L1HQS46whtBF6kAEGIgAAxHgXAS4saMCTLeqTmQTGYfkhMEK+iXoFAWd8eRM" +
               "vBB68PginuRL9v4yg1wDsMJN2XcRKJUzJz70wKHuW52vUPjJAvzEr7/1/Geu" +
               "g87NoHOGw2fiyECIEGwyg26xVXuu+kFDUVRlBt3uqKrCq74hWUaayz2DLgTG" +
               "wpHCyFcPjZQNRp7q53vuLHeLnOnmR3Lo+ofqaYZqKQffbtAsaQF0vWun61ZD" +
               "MhsHCp41gGC+JsnqAcv1puEoIXT/SY5DHS/2AQFgvdFWQ9093Op6RwID0IWt" +
               "7yzJWcB86BvOApDe4EZglxC65zkXzWztSbIpLdTLIXT3SbrBdgpQ3ZwbImMJ" +
               "oTtPkuUrAS/dc8JLR/zzfeb1j7/d6Tinc5kVVbYy+W8CTPedYOJUTfVVR1a3" +
               "jLe8lvqAdNfn330aggDxnSeItzS/94vPvvl19z3zxS3Ny69Cw86Xqhxelj8y" +
               "v+2rryAerl+XiXGT5wZG5vxjmufhP9ifuZR4IPPuOlwxm9w7mHyG+7Ppox9X" +
               "v3caOtuFzsiuFdkgjm6XXdszLNVvq47qS6GqdKGbVUch8vkudCPoU4ajbkdZ" +
               "TQvUsAtdb+VDZ9z8OzCRBpbITHQj6BuO5h70PSnU837iQRB0AfxDexB0ioPy" +
               "v1ODrA0hGdZdW4UlWXIMx4UHvpvpH8CqE86BbXV4DqLehAM38kEIwq6/gCUQ" +
               "B7q6PyF5XgAH68Xcd+NA9eEeL7ZFQ41VnwTpqu5lweb9/2yTZNqej0+dAo54" +
               "xUkYsEAGdVxLUf3L8hMR3nr2k5e/fPowLfbtFEIjsPPedue9fOe9bOe93c57" +
               "J3a+SEjOWgou7oabLL3tZJjiuxZwMHTqVC7VSzMxt6EBHGsCiADgecvD/C/0" +
               "3vbuh64DMenF12e+AaTwc2M4sQOVbg6dMohs6JkPxu8Qfxk5DZ0+DsaZamDo" +
               "bMY+yCD0ECovnkzCq6177rHv/vBTH3jE3aXjMXTfR4krObMsf+ikE3xXVhWA" +
               "m7vlX/uA9NnLn3/k4mnoegAdAC5DCYQ3QKL7Tu5xLNsvHSBnpssNQGHN9W3J" +
               "yqYO4O5sqAOP7Uby6Lgt798ObAxD2+YwH/LPbPYOL2tfuo2mzGkntMiR+Q28" +
               "9+G//Yt/QnNzH4D4uSOPRV4NLx0BjmyxczlE3L6LAcFXVUD3dx8cvP/J7z/2" +
               "83kAAIpXXm3Di1lLAMAALgRmftcXV9/49rc+8rXTu6AJwZMzmluGnGyV/DH4" +
               "OwX+/yf7z5TLBrZJf4HYR54HDqHHy3Z+9U42IgtcOY+giyPHdhVDM6S5pWYR" +
               "+1/nXlX87L88fn4bExYYOQip1z3/Arvxn8GhR7/81n+/L1/mlJw9BHf225Ft" +
               "kfWO3coN35c2mRzJO/7q3t/4gvRhgNEAFwMjVXOog3J7QLkDkdwWhbyFT8yV" +
               "sub+4GgiHM+1I8XKZfl9X/vBreIP/vDZXNrj1c5Rv9OSd2kbalnzQAKWf9nJ" +
               "rO9IgQ7oys8wbzlvPfMjsOIMrCgD4AtYHyBUcixK9qlvuPGbf/THd73tq9dB" +
               "p0norOVKCinlCQfdDCJdDXQAbon3pjdvwzm+CTTnc1WhK5TfBsjd+bfrgIAP" +
               "PzfWkFmxskvXu/+Ttebv/Pv/uMIIOcpc5Rl9gn8GP/2he4g3fi/n36V7xn1f" +
               "ciVqg8Jux1v6uP1vpx8686enoRtn0Hl5v2oUJSvKkmgGKqXgoJQEleWx+eNV" +
               "z/YRf+kQzl5xEmqObHsSaHZPC9DPqLP+2Z3DH05OgUS8obSH7SHZ9zfnjA/m" +
               "7cWs+dmt1bPua0DGBnn1CTg0w5GsfJ2HQxAxlnzxIEdFUI0CE19cWli+zJ2g" +
               "/s6jI1Nmb1vCbbEqa9GtFHm/+pzRcOlAVuD923aLUS6oBt/zD+/7yntf+W3g" +
               "oh50wzozH/DMkR2ZKCuQf+XpJ+99yRPfeU8OQAB9xEdf9a95udG/lsZZ08ya" +
               "1oGq92Sq8vljn5KCkM5xQlVyba8ZmQPfsAG0rverP/iRC982P/TdT2wru5Nh" +
               "eIJYffcTv/rjvcefOH2knn7lFSXtUZ5tTZ0Lfeu+hX3owWvtknOQ//ipRz73" +
               "W488tpXqwvHqsAVefj7x9f/+yt4Hv/Olq5Qi11vui3BseNtrOuWg2zj4o4oz" +
               "tRSPksTW2BSOWync0NeNeNrYrIi5SeGzXtsznUapjW+0YFESbZdf+nY90gbG" +
               "WilaSq1cYKtipU+UkJFhGr0esRpKSIu3ulZDHPfslcdw+KrY5XuMxQ2LghQN" +
               "VytrVDAbzMoTCkNljRRKM3QOayWtLVf6vojIKJ2itRTV5nBlsmQKmOF6dIzy" +
               "sTVUyxZdpRFG6euFhR6AmnHoFtNxa2ogrsNHC7huYV60YbobU+vBTXJVN/3R" +
               "jEE2owJl90kzWm0kZxUI9CCYG1GbakyJadozjAkzGY8Y2rIFxJvMWo69Fldy" +
               "V251Gb5vLia9aEO1kFmKlnAvDpblhjnlyZ7aB7W+wRCSwTEOSvVIdN1lUyTl" +
               "e9ZGndlysaWVkNiUBIeZESPFNFHFbHb6qW9YAj+aLLuzue5qaH+mR8Rk1mFU" +
               "jkCc1RoDIcwFExePh/3VSncnVc9upgw/IjhpYDY9NGyFel+jG4Wh6xkzfNVM" +
               "W86ca3ckzpjqbttzq0UKV6gJvRwr1ZBvsWE6W4mbyYjAWTESI9dim16UhLgr" +
               "0EGLJkN0NDGQztwSrZDi0VTspLXKupm00LWvFXGias56jhSzrrDgCRoEAr9o" +
               "bKxuMvP0eRltjTubEdPX01KryZirYCnUgaa20+M9IWaSAtxYuIzncDbhlQPR" +
               "IQbubDW0fN2a1TmKcNlEmw1tsmd2JjNLmfA1Juo0ZHJVGg7Tlj4MmiHGq3bZ" +
               "p6eVsUpqpjJOMK68WPQn6cjdDCTRGnv8imwoPdee6kRxzJWJVjIQhj3PHk7b" +
               "UofYeCxhG5TIepO2NCPbCI/DyqI5IsXeiCDIlOBnrCawccvDhJaCrNQaBt7i" +
               "C5Nuo+CxzGhBdDuszA/9/iQuUWNnQ+GWTbSHaS0mvWmwwTZ4u1ioTIhhi8Cj" +
               "mk7OmSZcq/ljrIip8rrU5KgeCJtloeQgZq3vldh0UnfGYw3r8COXc8eRLXRV" +
               "zcXsOAjaWM9ml40y5y1trItU2w7tpIsUhhFzoM3QGjCwq46MiscvXVIJhwuJ" +
               "txTRM5JF1aHdXkqqyAIkF6tM/Won7TIFjpRmjLLS+J5B1ys4zw03olToosMe" +
               "36A4wuhHS0oye2lh6VvTal9Dhqa+1Bp6d9QlFohQw4dSXBkN+8uS6ZGrKS+O" +
               "RZGIa9N25K11o2MkjeY8mDRov1Ouzdue10Di2MedHt0YYe32oIQzYpEuJWyv" +
               "zbaZhcPRVOJLbaFj0LFtKy0GCzxCaqdVuKwwuC8qNG5241YrqJVlHBcS16vO" +
               "WzbXFpcrFVXEItad+By9JBEiCRzBmTYrlSbJ8sOyXsHTDTuSaw4ZVavCCm9O" +
               "5ijbCeF5cYyX2L7LW3FMDIctshtyzVaIlIlmZyoPG0K76jmoC1so1vTV8aKF" +
               "rsyqWGbMpmR7rM8CyvJCgFcdvhRMZtWiOmL8WOlJ0yEycm1nNe17s2rE6f2G" +
               "vVRA1CRsk2KntgmiddbtzRCmYZKuMhUNwytR4UjCB3TcIVnS8Uoy2VVYZ1yW" +
               "+/3ZaFLZwJFgxht6gOquGStpbcGnVHcg6LVFmy6EjotG0qCdDsIxqrkbQ3Gc" +
               "1HAjrmX2Nq2KKnDrnuoPq748H6QJJynFfsGiEGvKhI31rG8MCHlhKkStnSa1" +
               "2qI3wots0FKUvtnU9bZkrro9oRnMRK2xoVMc4fCw1BBmjFUq6cRgQZLOemmY" +
               "A2w0r2OFGiLhXo/hq8tNMcaby86sHOteUDTcplgmfTOgW1OkU4zliEiSak0t" +
               "GQO6xevjtMbHTSVkCbIOwKS5EDc1WR3AzU1VXuMiIlRWHM+kQ1YIMAMkLhub" +
               "sE7FhAYXGh03rrFjsu0GCs3qfJQGIt6p2KFSE3zO3HB6p1TCxDneYvmOYNPU" +
               "UNcqYliaN3m0ho3sghI1ustl0A4cFGkq8AZUKrxuoGu4xPdLxMiYWiLSnQhd" +
               "v0jUY6VeWbU7w35FXtRgFtv06oWFgHT4RQsPNyFDJ2TZ6BIdo9mUKapdFjF+" +
               "rqEsOvWb7frMw3x+hq36vKusNS7B5GXHL5YFJJLGk3p1iVXFql4Su0XDbAQp" +
               "kdh2HLWYWrlUTZbRZtGkjXSTVFdKEd80U0FSMCxaT5YW3FEMtmEFvdifzOYI" +
               "LqcqNzWRosJEBdTHUHXNFpSWTgU9a9znooEiDhbyasgtZ4XpVGd5Wgs1xTII" +
               "gVSaIyJNuh2zV2mgi36/NC2g1eooDcY9gSrUqvQoFCqFKkUkQgjPptWwGPvj" +
               "5TwQrfWYr5TmNcuMR32O77IC3Suum0VDHQxZY10xBGHO2iZnb/B+v7Amcb3X" +
               "XVWRck0eJJP1ABvgfasmyeWIoVaG5cBwcV2v9R0trdspY4ZOHws6Y4saKQV2" +
               "bNtiwtPz1RKbDoBhUGxkhXHJijfN6aaUVvBmbT3sImNSLk9hnVRVlltv4tna" +
               "YQI02fDJ0NWsdTl0CsU6FiCKVBWXQ7GljFHT8Ks+O1EEnePG0/ZiEzX41crg" +
               "2WIc1MczpOj0Ra/fryzJoI1UY7QMB1WqmnamXa4qOVOU0JV2KdEtQ5zQLcaI" +
               "+QnC99J6qZUmNMB2ulAtL6mBL8Bx0tV4mmNWuGCShfGAoPwFPMDwAQv0qLU0" +
               "qm0XpOmUJIswRxd6wRIrFGE+SRRc8frkkhg4U5xR5z11IEz1endZ6obaZNJx" +
               "CDwJ4M4AZrN3YFXboDhXS1g0rbUrhfZS36ADelwdrVA2qovlYnE56Xt1ZFX2" +
               "khYfVWFUKJW7BY2dLFypzdSbtYYMqhVyJIgY6ZJBaS7HJCJSxaio+fC6h8gS" +
               "P3eazY7V58Ro1JSUqZCmE1IdT6sVtyOup+OKblvUUrQnZq1R7SVJoTEL9RUG" +
               "WzQyMzoMKHvhTsGnxqVyPVFcRq2H/kQd14RawDk9BuYIvhxMZczvosSw1Gps" +
               "5r0pg5tCp4V1U44vjstrzmMLVCUsrglGSOqxOECGCD6sVkQkKjeTuFFo1jp0" +
               "JcSJjcEYcy6SmZnUNrkNXg7ptVyc45jpNf1eoTNjeIM2m+6UasmD3lLsuv5K" +
               "JNgZTbhTAA+tLiW3y80Voc0k00u56nI40mv9hZLU0M2y3+okAhDRFrkJxQcd" +
               "P+CphSM3bYJQi+W+XibrRpjUWibO28VyHBbi6dhXWn2hvKkgKOZxCIu0lvIs" +
               "hGXNaVol3ZPHulRDU2bC8Li+EUAEmVFFW2jStGvRdaNWLMZSmbVcet6N/HG9" +
               "Y6uaMuhgqIsSWDIb8hiDI6zETqptK9Hafh32Zp3CkI5Vh+zaRn1JF2fCyqMX" +
               "IqtNZnil1fTRNdIAMOps3FXNWC4kVKtNURIxJgbMqGoVmfCRTY7QkWggWKiZ" +
               "9ZEfWpMEX7mDpOdxWscUxjWWUmTG8hokt5yMrZE5maSwNWPFgDb6comrE0Fd" +
               "DRIBXnptp52ozQlIZgAcDc2rqGMzpRJMGmMEk8issRj50+qk0i6yvNtoRRg8" +
               "CrC5oRuO7wi0sKFqHDEMXTtAiMCMalTMTd2p5agrtcWLwaAudjysbynasC5H" +
               "hRJdH3X1/oQDBZPq6QFFqgutJ0Yln4gwGyPHhQBGq3CHFaXKpt+PVDIhonnQ" +
               "YmJSa48CmkMnqTYPQq1UR+prVRtN9Npa00UvboKXDkGfBzVhw4+RJe4JNaZY" +
               "HdVNLSaa43K5bLR1F0bnI1SNBDitK4X+hpc2xNyy9MJKR6qqg2moGNRUe9zt" +
               "O1F3LA4piqL7fZtP1aJQBZjccxNuZETzCWcOWxOJW816AiwXO6vqvLwAz6NA" +
               "bQfpFDOQZNwqwhuJWcN4c4PZZXI9D6mhlJRKC22VlDiUKmglHOMtUSqiCIXi" +
               "5KDN1+fGMBk0CnHSjhxRUTXOq3IUWSaNdVqIjVE7KSwKBgi4DhyPF4jSk2M9" +
               "AC+Gb3hD9sr4lhf21n57fkBxeOEEXtazifYLeFtNrr7hqRC62fPdMIM9JTk8" +
               "rc0Ys8721uLg88hp7ZETrVMHpyTl5z3Lv8pRffZef+9z3U7l7/QfeecTTyns" +
               "R4un948RxyF0Zv/ScCfEGbDMa5/78ILOb+Z2Z1tfeOc/3yO8UX/bCzi9v/+E" +
               "kCeX/G366S+1Xy3/2mnousOTrivuDI8zXTp+vnXWV8MIZOmxU657D33y8swF" +
               "DwF7C/s+Ea5+gn51P+eBtQ2naxzRrq8xlzerELpRlpyWYmzvj7kjcSeCubnr" +
               "Wqrk7GLSf74TlKPb5APOocYPZ4NvAsJP9jWe/OQ1ftc15h7LmkdD6C7ZV6VQ" +
               "5dX9E3JacqTFfviBuK8+b9xn1/iqE7Jr1bekzVH23EbveBE2ek02iAJ1L+/b" +
               "6PJP3kbvv8bck1nzeAi9ZKGGTVeOMj0PDPPSzDAxKu8prr13bDJX+70vQu07" +
               "ssEi0EDeV1v+yah96jikXdgdw3KR42T3KTnbb17DIh/Nmg+F0K2e6mfXZCNP" +
               "AcFztWy5fu0ays4eH36x9ugAyc19e5g/FXs8dEWoB7EBjLNYh3v70Z0v85lr" +
               "2Od3s+YTIKt81XbXu6za589mP7YzyidfrFF+Dojv7hvF/akY5fzRMGdcZRsi" +
               "z1zDBH+SNZ8LobNBrnzGc0LtP3ghaichdO8178MPJMX+j7ft4OF69xW/89n+" +
               "NkX+5FPnbnrZU6O/yW+UD38/cjMF3aRFlnX0+uZI/4znq5qR2+Lm7WWOl3/8" +
               "eQg98HwyZmY7/JJr9pUt81+G0J1XZQaZln0cpf3rfbcdpQ2hG/LPo3RfB7vt" +
               "6EDlse0cJflGCF0HSLLuN72r3Bhtr7+SU0eqlf1IzT194fk8fchy9KY6q3Dy" +
               "H2gdVCPR9idal+VPPdVj3v5s9aPbm3LZktI0W+UmCrpxe2l/WNE8+JyrHax1" +
               "pvPwj2779M2vOii9btsKvMuaI7Ldf/Wr6Jbthfnlcfr7L/ud13/sqW/lF1j/" +
               "C8UV2t85JwAA");
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "B2/4vbf91gvfzqta/wskyDdHkSAAAA==");
    }
    protected javax.swing.JPanel svgCanvasPanel;
    protected javax.swing.JWindow window;
    protected static javax.swing.JFrame memoryMonitorFrame;
    protected java.io.File currentPath = new java.io.File(
      "");
    protected java.io.File currentSavePath =
      new java.io.File(
      "");
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.BackAction
      backAction =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.BackAction(
      );
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ForwardAction
      forwardAction =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ForwardAction(
      );
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.PlayAction
      playAction =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.PlayAction(
      );
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.PauseAction
      pauseAction =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.PauseAction(
      );
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.StopAction
      stopAction =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.StopAction(
      );
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.PreviousTransformAction
      previousTransformAction =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.PreviousTransformAction(
      );
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.NextTransformAction
      nextTransformAction =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.NextTransformAction(
      );
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.UseStylesheetAction
      useStylesheetAction =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.UseStylesheetAction(
      );
    protected boolean debug;
    protected boolean autoAdjust = true;
    protected boolean managerStopped;
    protected org.apache.batik.swing.svg.SVGUserAgent
      userAgent =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.UserAgent(
      );
    protected org.w3c.dom.svg.SVGDocument
      svgDocument;
    protected org.apache.batik.util.gui.URIChooser
      uriChooser;
    protected org.apache.batik.apps.svgbrowser.DOMViewer
      domViewer;
    protected org.apache.batik.apps.svgbrowser.FindDialog
      findDialog;
    protected org.apache.batik.apps.svgbrowser.ThumbnailDialog
      thumbnailDialog;
    protected org.apache.batik.ext.swing.JAffineTransformChooser.Dialog
      transformDialog;
    protected org.apache.batik.util.gui.LocationBar
      locationBar;
    protected org.apache.batik.apps.svgbrowser.StatusBar
      statusBar;
    protected java.lang.String title;
    protected org.apache.batik.apps.svgbrowser.LocalHistory
      localHistory;
    protected org.apache.batik.apps.svgbrowser.TransformHistory
      transformHistory =
      new org.apache.batik.apps.svgbrowser.TransformHistory(
      );
    protected java.lang.String alternateStyleSheet;
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.Debugger
      debugger;
    public JSVGViewerFrame(org.apache.batik.apps.svgbrowser.Application app) {
        super(
          );
        application =
          app;
        addWindowListener(
          new java.awt.event.WindowAdapter(
            ) {
              public void windowClosing(java.awt.event.WindowEvent e) {
                  application.
                    closeJSVGViewerFrame(
                      JSVGViewerFrame.this);
              }
          });
        svgCanvas =
          new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.Canvas(
            userAgent,
            true,
            true) {
              java.awt.Dimension
                screenSize;
              {
                  screenSize =
                    java.awt.Toolkit.
                      getDefaultToolkit(
                        ).
                      getScreenSize(
                        );
                  setMaximumSize(
                    screenSize);
              }
              public java.awt.Dimension getPreferredSize() {
                  java.awt.Dimension s =
                    super.
                    getPreferredSize(
                      );
                  if (s.
                        width >
                        screenSize.
                          width)
                      s.
                        width =
                        screenSize.
                          width;
                  if (s.
                        height >
                        screenSize.
                          height)
                      s.
                        height =
                        screenSize.
                          height;
                  return s;
              }
              public void setMySize(java.awt.Dimension d) {
                  setPreferredSize(
                    d);
                  invalidate(
                    );
                  if (JSVGViewerFrame.this.
                        autoAdjust) {
                      org.apache.batik.util.Platform.
                        unmaximize(
                          JSVGViewerFrame.this);
                      JSVGViewerFrame.this.
                        pack(
                          );
                  }
              }
              public void setDisableInteractions(boolean b) {
                  super.
                    setDisableInteractions(
                      b);
                  ((javax.swing.Action)
                     listeners.
                     get(
                       SET_TRANSFORM_ACTION)).
                    setEnabled(
                      !b);
                  if (thumbnailDialog !=
                        null)
                      thumbnailDialog.
                        setInteractionEnabled(
                          !b);
              }
          };
        javax.swing.ActionMap map =
          svgCanvas.
          getActionMap(
            );
        map.
          put(
            FULL_SCREEN_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.FullScreenAction(
              ));
        javax.swing.InputMap imap =
          svgCanvas.
          getInputMap(
            javax.swing.JComponent.
              WHEN_FOCUSED);
        javax.swing.KeyStroke key =
          javax.swing.KeyStroke.
          getKeyStroke(
            java.awt.event.KeyEvent.
              VK_F11,
            0);
        imap.
          put(
            key,
            FULL_SCREEN_ACTION);
        svgCanvas.
          setDoubleBufferedRendering(
            true);
        listeners.
          put(
            ABOUT_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.AboutAction(
              ));
        listeners.
          put(
            OPEN_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.OpenAction(
              ));
        listeners.
          put(
            OPEN_LOCATION_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.OpenLocationAction(
              ));
        listeners.
          put(
            NEW_WINDOW_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.NewWindowAction(
              ));
        listeners.
          put(
            RELOAD_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ReloadAction(
              ));
        listeners.
          put(
            SAVE_AS_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.SaveAsAction(
              ));
        listeners.
          put(
            BACK_ACTION,
            backAction);
        listeners.
          put(
            FORWARD_ACTION,
            forwardAction);
        listeners.
          put(
            PRINT_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.PrintAction(
              ));
        listeners.
          put(
            EXPORT_AS_JPG_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ExportAsJPGAction(
              ));
        listeners.
          put(
            EXPORT_AS_PNG_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ExportAsPNGAction(
              ));
        listeners.
          put(
            EXPORT_AS_TIFF_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ExportAsTIFFAction(
              ));
        listeners.
          put(
            PREFERENCES_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.PreferencesAction(
              ));
        listeners.
          put(
            CLOSE_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.CloseAction(
              ));
        listeners.
          put(
            EXIT_ACTION,
            application.
              createExitAction(
                this));
        listeners.
          put(
            VIEW_SOURCE_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ViewSourceAction(
              ));
        javax.swing.ActionMap cMap =
          svgCanvas.
          getActionMap(
            );
        listeners.
          put(
            RESET_TRANSFORM_ACTION,
            cMap.
              get(
                org.apache.batik.swing.JSVGCanvas.
                  RESET_TRANSFORM_ACTION));
        listeners.
          put(
            ZOOM_IN_ACTION,
            cMap.
              get(
                org.apache.batik.swing.JSVGCanvas.
                  ZOOM_IN_ACTION));
        listeners.
          put(
            ZOOM_OUT_ACTION,
            cMap.
              get(
                org.apache.batik.swing.JSVGCanvas.
                  ZOOM_OUT_ACTION));
        listeners.
          put(
            PREVIOUS_TRANSFORM_ACTION,
            previousTransformAction);
        key =
          javax.swing.KeyStroke.
            getKeyStroke(
              java.awt.event.KeyEvent.
                VK_K,
              java.awt.event.KeyEvent.
                CTRL_MASK);
        imap.
          put(
            key,
            previousTransformAction);
        listeners.
          put(
            NEXT_TRANSFORM_ACTION,
            nextTransformAction);
        key =
          javax.swing.KeyStroke.
            getKeyStroke(
              java.awt.event.KeyEvent.
                VK_L,
              java.awt.event.KeyEvent.
                CTRL_MASK);
        imap.
          put(
            key,
            nextTransformAction);
        listeners.
          put(
            USE_STYLESHEET_ACTION,
            useStylesheetAction);
        listeners.
          put(
            PLAY_ACTION,
            playAction);
        listeners.
          put(
            PAUSE_ACTION,
            pauseAction);
        listeners.
          put(
            STOP_ACTION,
            stopAction);
        listeners.
          put(
            MONITOR_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.MonitorAction(
              ));
        listeners.
          put(
            DOM_VIEWER_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.DOMViewerAction(
              ));
        listeners.
          put(
            SET_TRANSFORM_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.SetTransformAction(
              ));
        listeners.
          put(
            FIND_DIALOG_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.FindDialogAction(
              ));
        listeners.
          put(
            THUMBNAIL_DIALOG_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ThumbnailDialogAction(
              ));
        listeners.
          put(
            FLUSH_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.FlushAction(
              ));
        listeners.
          put(
            TOGGLE_DEBUGGER_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ToggleDebuggerAction(
              ));
        javax.swing.JPanel p =
          null;
        try {
            org.apache.batik.util.gui.resource.MenuFactory mf =
              new org.apache.batik.util.gui.resource.MenuFactory(
              bundle,
              this);
            javax.swing.JMenuBar mb =
              mf.
              createJMenuBar(
                "MenuBar",
                application.
                  getUISpecialization(
                    ));
            setJMenuBar(
              mb);
            localHistory =
              new org.apache.batik.apps.svgbrowser.LocalHistory(
                mb,
                this);
            java.lang.String[] uri =
              application.
              getVisitedURIs(
                );
            for (int i =
                   0;
                 i <
                   uri.
                     length;
                 i++) {
                if (uri[i] !=
                      null &&
                      !"".
                      equals(
                        uri[i])) {
                    localHistory.
                      update(
                        uri[i]);
                }
            }
            p =
              new javax.swing.JPanel(
                new java.awt.BorderLayout(
                  ));
            org.apache.batik.util.gui.resource.ToolBarFactory tbf =
              new org.apache.batik.util.gui.resource.ToolBarFactory(
              bundle,
              this);
            javax.swing.JToolBar tb =
              tbf.
              createJToolBar(
                "ToolBar");
            tb.
              setFloatable(
                false);
            getContentPane(
              ).
              add(
                p,
                java.awt.BorderLayout.
                  NORTH);
            p.
              add(
                tb,
                java.awt.BorderLayout.
                  NORTH);
            p.
              add(
                new javax.swing.JSeparator(
                  ),
                java.awt.BorderLayout.
                  CENTER);
            p.
              add(
                locationBar =
                  new org.apache.batik.util.gui.LocationBar(
                    ),
                java.awt.BorderLayout.
                  SOUTH);
            locationBar.
              setBorder(
                javax.swing.BorderFactory.
                  createEmptyBorder(
                    2,
                    2,
                    2,
                    2));
        }
        catch (java.util.MissingResourceException e) {
            java.lang.System.
              out.
              println(
                e.
                  getMessage(
                    ));
            java.lang.System.
              exit(
                0);
        }
        svgCanvasPanel =
          new javax.swing.JPanel(
            new java.awt.BorderLayout(
              ));
        svgCanvasPanel.
          setBorder(
            javax.swing.BorderFactory.
              createEtchedBorder(
                ));
        svgCanvasPanel.
          add(
            svgCanvas,
            java.awt.BorderLayout.
              CENTER);
        p =
          new javax.swing.JPanel(
            new java.awt.BorderLayout(
              ));
        p.
          add(
            svgCanvasPanel,
            java.awt.BorderLayout.
              CENTER);
        p.
          add(
            statusBar =
              new org.apache.batik.apps.svgbrowser.StatusBar(
                ),
            java.awt.BorderLayout.
              SOUTH);
        getContentPane(
          ).
          add(
            p,
            java.awt.BorderLayout.
              CENTER);
        svgCanvas.
          addSVGDocumentLoaderListener(
            this);
        svgCanvas.
          addGVTTreeBuilderListener(
            this);
        svgCanvas.
          addSVGLoadEventDispatcherListener(
            this);
        svgCanvas.
          addGVTTreeRendererListener(
            this);
        svgCanvas.
          addLinkActivationListener(
            this);
        svgCanvas.
          addUpdateManagerListener(
            this);
        svgCanvas.
          addMouseMotionListener(
            new java.awt.event.MouseMotionAdapter(
              ) {
                public void mouseMoved(java.awt.event.MouseEvent e) {
                    if (svgDocument ==
                          null) {
                        statusBar.
                          setXPosition(
                            e.
                              getX(
                                ));
                        statusBar.
                          setYPosition(
                            e.
                              getY(
                                ));
                    }
                    else {
                        try {
                            java.awt.geom.AffineTransform at;
                            at =
                              svgCanvas.
                                getViewBoxTransform(
                                  );
                            if (at !=
                                  null) {
                                at =
                                  at.
                                    createInverse(
                                      );
                                java.awt.geom.Point2D p2d =
                                  at.
                                  transform(
                                    new java.awt.geom.Point2D.Float(
                                      e.
                                        getX(
                                          ),
                                      e.
                                        getY(
                                          )),
                                    null);
                                statusBar.
                                  setXPosition(
                                    (float)
                                      p2d.
                                      getX(
                                        ));
                                statusBar.
                                  setYPosition(
                                    (float)
                                      p2d.
                                      getY(
                                        ));
                                return;
                            }
                        }
                        catch (java.awt.geom.NoninvertibleTransformException ex) {
                            
                        }
                        statusBar.
                          setXPosition(
                            e.
                              getX(
                                ));
                        statusBar.
                          setYPosition(
                            e.
                              getY(
                                ));
                    }
                }
            });
        svgCanvas.
          addMouseListener(
            new java.awt.event.MouseAdapter(
              ) {
                public void mouseExited(java.awt.event.MouseEvent e) {
                    java.awt.Dimension dim =
                      svgCanvas.
                      getSize(
                        );
                    if (svgDocument ==
                          null) {
                        statusBar.
                          setWidth(
                            dim.
                              width);
                        statusBar.
                          setHeight(
                            dim.
                              height);
                    }
                    else {
                        try {
                            java.awt.geom.AffineTransform at;
                            at =
                              svgCanvas.
                                getViewBoxTransform(
                                  );
                            if (at !=
                                  null) {
                                at =
                                  at.
                                    createInverse(
                                      );
                                java.awt.geom.Point2D o =
                                  at.
                                  transform(
                                    new java.awt.geom.Point2D.Float(
                                      0,
                                      0),
                                    null);
                                java.awt.geom.Point2D p2d =
                                  at.
                                  transform(
                                    new java.awt.geom.Point2D.Float(
                                      dim.
                                        width,
                                      dim.
                                        height),
                                    null);
                                statusBar.
                                  setWidth(
                                    (float)
                                      (p2d.
                                         getX(
                                           ) -
                                         o.
                                         getX(
                                           )));
                                statusBar.
                                  setHeight(
                                    (float)
                                      (p2d.
                                         getY(
                                           ) -
                                         o.
                                         getY(
                                           )));
                                return;
                            }
                        }
                        catch (java.awt.geom.NoninvertibleTransformException ex) {
                            
                        }
                        statusBar.
                          setWidth(
                            dim.
                              width);
                        statusBar.
                          setHeight(
                            dim.
                              height);
                    }
                }
            });
        svgCanvas.
          addComponentListener(
            new java.awt.event.ComponentAdapter(
              ) {
                public void componentResized(java.awt.event.ComponentEvent e) {
                    java.awt.Dimension dim =
                      svgCanvas.
                      getSize(
                        );
                    if (svgDocument ==
                          null) {
                        statusBar.
                          setWidth(
                            dim.
                              width);
                        statusBar.
                          setHeight(
                            dim.
                              height);
                    }
                    else {
                        try {
                            java.awt.geom.AffineTransform at;
                            at =
                              svgCanvas.
                                getViewBoxTransform(
                                  );
                            if (at !=
                                  null) {
                                at =
                                  at.
                                    createInverse(
                                      );
                                java.awt.geom.Point2D o =
                                  at.
                                  transform(
                                    new java.awt.geom.Point2D.Float(
                                      0,
                                      0),
                                    null);
                                java.awt.geom.Point2D p2d =
                                  at.
                                  transform(
                                    new java.awt.geom.Point2D.Float(
                                      dim.
                                        width,
                                      dim.
                                        height),
                                    null);
                                statusBar.
                                  setWidth(
                                    (float)
                                      (p2d.
                                         getX(
                                           ) -
                                         o.
                                         getX(
                                           )));
                                statusBar.
                                  setHeight(
                                    (float)
                                      (p2d.
                                         getY(
                                           ) -
                                         o.
                                         getY(
                                           )));
                                return;
                            }
                        }
                        catch (java.awt.geom.NoninvertibleTransformException ex) {
                            
                        }
                        statusBar.
                          setWidth(
                            dim.
                              width);
                        statusBar.
                          setHeight(
                            dim.
                              height);
                    }
                }
            });
        locationBar.
          addActionListener(
            new javax.swing.AbstractAction(
              ) {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    java.lang.String st =
                      locationBar.
                      getText(
                        ).
                      trim(
                        );
                    int i =
                      st.
                      indexOf(
                        '#');
                    java.lang.String t =
                      "";
                    if (i !=
                          -1) {
                        t =
                          st.
                            substring(
                              i +
                                1);
                        st =
                          st.
                            substring(
                              0,
                              i);
                    }
                    if (st.
                          equals(
                            ""))
                        return;
                    try {
                        java.io.File f =
                          new java.io.File(
                          st);
                        if (f.
                              exists(
                                )) {
                            if (f.
                                  isDirectory(
                                    )) {
                                return;
                            }
                            else {
                                try {
                                    st =
                                      f.
                                        getCanonicalPath(
                                          );
                                    if (st.
                                          startsWith(
                                            "/")) {
                                        st =
                                          "file:" +
                                          st;
                                    }
                                    else {
                                        st =
                                          "file:/" +
                                          st;
                                    }
                                }
                                catch (java.io.IOException ex) {
                                    
                                }
                            }
                        }
                    }
                    catch (java.lang.SecurityException se) {
                        
                    }
                    java.lang.String fi =
                      svgCanvas.
                      getFragmentIdentifier(
                        );
                    if (svgDocument !=
                          null) {
                        org.apache.batik.util.ParsedURL docPURL =
                          new org.apache.batik.util.ParsedURL(
                          svgDocument.
                            getURL(
                              ));
                        org.apache.batik.util.ParsedURL purl =
                          new org.apache.batik.util.ParsedURL(
                          docPURL,
                          st);
                        fi =
                          fi ==
                            null
                            ? ""
                            : fi;
                        if (docPURL.
                              equals(
                                purl) &&
                              t.
                              equals(
                                fi)) {
                            return;
                        }
                    }
                    if (t.
                          length(
                            ) !=
                          0) {
                        st +=
                          '#' +
                          t;
                    }
                    locationBar.
                      setText(
                        st);
                    locationBar.
                      addToHistory(
                        st);
                    showSVGDocument(
                      st);
                }
            });
    }
    public void dispose() { hideDebugger(
                              );
                            svgCanvas.dispose(
                                        );
                            super.dispose(
                                    ); }
    public void setDebug(boolean b) { debug =
                                        b;
    }
    public void setAutoAdjust(boolean b) {
        autoAdjust =
          b;
    }
    public org.apache.batik.swing.JSVGCanvas getJSVGCanvas() {
        return svgCanvas;
    }
    private static java.io.File makeAbsolute(java.io.File f) {
        if (!f.
              isAbsolute(
                )) {
            return f.
              getAbsoluteFile(
                );
        }
        return f;
    }
    public void showDebugger() { if (debugger ==
                                       null &&
                                       org.apache.batik.apps.svgbrowser.JSVGViewerFrame.Debugger.
                                         isPresent) {
                                     debugger =
                                       new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.Debugger(
                                         this,
                                         locationBar.
                                           getText(
                                             ));
                                     debugger.
                                       initialize(
                                         );
                                 } }
    public void hideDebugger() { if (debugger !=
                                       null) {
                                     debugger.
                                       clearAllBreakpoints(
                                         );
                                     debugger.
                                       go(
                                         );
                                     debugger.
                                       dispose(
                                         );
                                     debugger =
                                       null;
                                 } }
    protected static class Debugger {
        protected static boolean isPresent;
        protected static java.lang.Class debuggerClass;
        protected static java.lang.Class contextFactoryClass;
        protected static final int CLEAR_ALL_BREAKPOINTS_METHOD =
          0;
        protected static final int GO_METHOD =
          1;
        protected static final int SET_EXIT_ACTION_METHOD =
          2;
        protected static final int ATTACH_TO_METHOD =
          3;
        protected static final int DETACH_METHOD =
          4;
        protected static final int DISPOSE_METHOD =
          5;
        protected static final int GET_DEBUG_FRAME_METHOD =
          6;
        protected static java.lang.reflect.Constructor
          debuggerConstructor;
        protected static java.lang.reflect.Method[]
          debuggerMethods;
        protected static java.lang.Class rhinoInterpreterClass;
        protected static java.lang.reflect.Method
          getContextFactoryMethod;
        static { try { java.lang.Class dc =
                         java.lang.Class.
                         forName(
                           "org.mozilla.javascript.tools.debugger.Main");
                       java.lang.Class cfc =
                         java.lang.Class.
                         forName(
                           "org.mozilla.javascript.ContextFactory");
                       rhinoInterpreterClass =
                         java.lang.Class.
                           forName(
                             "org.apache.batik.script.rhino.RhinoInterpreter");
                       debuggerConstructor =
                         dc.
                           getConstructor(
                             new java.lang.Class[] { java.lang.String.class });
                       debuggerMethods = (new java.lang.reflect.Method[] { dc.
                                            getMethod(
                                              "clearAllBreakpoints",
                                              (java.lang.Class[])
                                                null),
                                          dc.
                                            getMethod(
                                              "go",
                                              (java.lang.Class[])
                                                null),
                                          dc.
                                            getMethod(
                                              "setExitAction",
                                              new java.lang.Class[] { java.lang.Runnable.class }),
                                          dc.
                                            getMethod(
                                              "attachTo",
                                              new java.lang.Class[] { cfc }),
                                          dc.
                                            getMethod(
                                              "detach",
                                              (java.lang.Class[])
                                                null),
                                          dc.
                                            getMethod(
                                              "dispose",
                                              (java.lang.Class[])
                                                null),
                                          dc.
                                            getMethod(
                                              "getDebugFrame",
                                              (java.lang.Class[])
                                                null) });
                       getContextFactoryMethod =
                         rhinoInterpreterClass.
                           getMethod(
                             "getContextFactory",
                             (java.lang.Class[])
                               null);
                       debuggerClass = dc;
                       isPresent = true; }
                 catch (java.lang.ClassNotFoundException cnfe) {
                     
                 }
                 catch (java.lang.NoSuchMethodException nsme) {
                     
                 }
                 catch (java.lang.SecurityException se) {
                     
                 } }
        protected java.lang.Object debuggerInstance;
        protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame
          svgFrame;
        public Debugger(org.apache.batik.apps.svgbrowser.JSVGViewerFrame frame,
                        java.lang.String url) {
            super(
              );
            svgFrame =
              frame;
            try {
                debuggerInstance =
                  debuggerConstructor.
                    newInstance(
                      new java.lang.Object[] { "JavaScript Debugger - " +
                      url });
            }
            catch (java.lang.IllegalAccessException iae) {
                throw new java.lang.RuntimeException(
                  iae.
                    getMessage(
                      ));
            }
            catch (java.lang.reflect.InvocationTargetException ite) {
                ite.
                  printStackTrace(
                    );
                throw new java.lang.RuntimeException(
                  ite.
                    getMessage(
                      ));
            }
            catch (java.lang.InstantiationException ie) {
                throw new java.lang.RuntimeException(
                  ie.
                    getMessage(
                      ));
            }
        }
        public void setDocumentURL(java.lang.String url) {
            getDebugFrame(
              ).
              setTitle(
                "JavaScript Debugger - " +
                url);
        }
        public void initialize() { javax.swing.JFrame debugGui =
                                     getDebugFrame(
                                       );
                                   javax.swing.JMenuBar menuBar =
                                     debugGui.
                                     getJMenuBar(
                                       );
                                   javax.swing.JMenu menu =
                                     menuBar.
                                     getMenu(
                                       0);
                                   menu.getItem(
                                          0).
                                     setEnabled(
                                       false);
                                   menu.getItem(
                                          1).
                                     setEnabled(
                                       false);
                                   menu.getItem(
                                          3).
                                     setText(
                                       org.apache.batik.apps.svgbrowser.Resources.
                                         getString(
                                           "Close.text"));
                                   menu.getItem(
                                          3).
                                     setAccelerator(
                                       javax.swing.KeyStroke.
                                         getKeyStroke(
                                           java.awt.event.KeyEvent.
                                             VK_W,
                                           java.awt.Event.
                                             CTRL_MASK));
                                   debugGui.
                                     setSize(
                                       600,
                                       460);
                                   debugGui.
                                     pack(
                                       );
                                   setExitAction(
                                     new java.lang.Runnable(
                                       ) {
                                         public void run() {
                                             svgFrame.
                                               hideDebugger(
                                                 );
                                         }
                                     });
                                   java.awt.event.WindowAdapter wa =
                                     new java.awt.event.WindowAdapter(
                                     ) {
                                       public void windowClosing(java.awt.event.WindowEvent e) {
                                           svgFrame.
                                             hideDebugger(
                                               );
                                       }
                                   };
                                   debugGui.
                                     addWindowListener(
                                       wa);
                                   debugGui.
                                     setVisible(
                                       true);
                                   attach(
                                     ); }
        public void attach() { java.lang.Object interpreter =
                                 svgFrame.
                                   svgCanvas.
                                 getRhinoInterpreter(
                                   );
                               if (interpreter !=
                                     null) {
                                   attachTo(
                                     getContextFactory(
                                       interpreter));
                               } }
        protected javax.swing.JFrame getDebugFrame() {
            try {
                return (javax.swing.JFrame)
                         debuggerMethods[GET_DEBUG_FRAME_METHOD].
                         invoke(
                           debuggerInstance,
                           (java.lang.Object[])
                             null);
            }
            catch (java.lang.reflect.InvocationTargetException ite) {
                throw new java.lang.RuntimeException(
                  ite.
                    getMessage(
                      ));
            }
            catch (java.lang.IllegalAccessException iae) {
                throw new java.lang.RuntimeException(
                  iae.
                    getMessage(
                      ));
            }
        }
        protected void setExitAction(java.lang.Runnable r) {
            try {
                debuggerMethods[SET_EXIT_ACTION_METHOD].
                  invoke(
                    debuggerInstance,
                    new java.lang.Object[] { r });
            }
            catch (java.lang.reflect.InvocationTargetException ite) {
                throw new java.lang.RuntimeException(
                  ite.
                    getMessage(
                      ));
            }
            catch (java.lang.IllegalAccessException iae) {
                throw new java.lang.RuntimeException(
                  iae.
                    getMessage(
                      ));
            }
        }
        public void attachTo(java.lang.Object contextFactory) {
            try {
                debuggerMethods[ATTACH_TO_METHOD].
                  invoke(
                    debuggerInstance,
                    new java.lang.Object[] { contextFactory });
            }
            catch (java.lang.reflect.InvocationTargetException ite) {
                throw new java.lang.RuntimeException(
                  ite.
                    getMessage(
                      ));
            }
            catch (java.lang.IllegalAccessException iae) {
                throw new java.lang.RuntimeException(
                  iae.
                    getMessage(
                      ));
            }
        }
        public void detach() { try { debuggerMethods[DETACH_METHOD].
                                       invoke(
                                         debuggerInstance,
                                         (java.lang.Object[])
                                           null);
                               }
                               catch (java.lang.reflect.InvocationTargetException ite) {
                                   throw new java.lang.RuntimeException(
                                     ite.
                                       getMessage(
                                         ));
                               }
                               catch (java.lang.IllegalAccessException iae) {
                                   throw new java.lang.RuntimeException(
                                     iae.
                                       getMessage(
                                         ));
                               } }
        public void go() { try { debuggerMethods[GO_METHOD].
                                   invoke(
                                     debuggerInstance,
                                     (java.lang.Object[])
                                       null);
                           }
                           catch (java.lang.reflect.InvocationTargetException ite) {
                               throw new java.lang.RuntimeException(
                                 ite.
                                   getMessage(
                                     ));
                           }
                           catch (java.lang.IllegalAccessException iae) {
                               throw new java.lang.RuntimeException(
                                 iae.
                                   getMessage(
                                     ));
                           } }
        public void clearAllBreakpoints() {
            try {
                debuggerMethods[CLEAR_ALL_BREAKPOINTS_METHOD].
                  invoke(
                    debuggerInstance,
                    (java.lang.Object[])
                      null);
            }
            catch (java.lang.reflect.InvocationTargetException ite) {
                throw new java.lang.RuntimeException(
                  ite.
                    getMessage(
                      ));
            }
            catch (java.lang.IllegalAccessException iae) {
                throw new java.lang.RuntimeException(
                  iae.
                    getMessage(
                      ));
            }
        }
        public void dispose() { try { debuggerMethods[DISPOSE_METHOD].
                                        invoke(
                                          debuggerInstance,
                                          (java.lang.Object[])
                                            null);
                                }
                                catch (java.lang.reflect.InvocationTargetException ite) {
                                    throw new java.lang.RuntimeException(
                                      ite.
                                        getMessage(
                                          ));
                                }
                                catch (java.lang.IllegalAccessException iae) {
                                    throw new java.lang.RuntimeException(
                                      iae.
                                        getMessage(
                                          ));
                                } }
        protected java.lang.Object getContextFactory(java.lang.Object rhinoInterpreter) {
            try {
                return getContextFactoryMethod.
                  invoke(
                    rhinoInterpreter,
                    (java.lang.Object[])
                      null);
            }
            catch (java.lang.reflect.InvocationTargetException ite) {
                throw new java.lang.RuntimeException(
                  ite.
                    getMessage(
                      ));
            }
            catch (java.lang.IllegalAccessException iae) {
                throw new java.lang.RuntimeException(
                  iae.
                    getMessage(
                      ));
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "DAYiOZ3jUmQxvGGSBEdqwWzYt+bieMiS");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("fYjoh2Ta97SNDIJFaZhhKrOkRw1E4gdOSC8a0Zyyuy6soXzMBj3dXZaRyZzk" +
           "KY1NtKwxHYnWaIBaraSpU5pKdPUJvqbTpc2b2Wg2ppiKiffUeWhup3Qe0jTN" +
           "aLwoW3CTrGykbWMVS/g4qgabVuSqwdggHQthqAUybtZUy1s0gfqEU7ZnLqQG" +
           "242zZYOJaDpeT1OYZRe9sbueDqlIUmJ72xg0epZiiyoXkGnKd5cq1RZDt7ee" +
           "k5RizpZVhlhVy96oD2RI1XsqG3l1O5RNCaIX/cYC3Yz7nNzQulONkjq1Psuy" +
           "aJk0xxHNYPgwY/CWnXbGaYwp46Gpjrs+mF5NiRzddjFrbQ/7pEsutcpy6NPW" +
           "crEYgSE6fNSh5DajrCajQdaMUA7LaozfCFapMNjAmaxsBnh/ZFuTkdDtbE3d" +
           "SyRvYfcHm54w7OByBxZq4+ocEc0ZTXu9Kc9v9YjmzM4EHi54zvJ4txJ3uFDc" +
           "9svGeg2NTGCdZm/mZ27Cd63JdqCPx9OknMKiURtRVQRqdaqNiUkuGgGRLRbb" +
           "zgZnNkML3o5hWQxgqkXBzTGDzWVg9+lshmf1Nip2zYBM2GxKVOpJ0jCbq3rY" +
           "E5bTOhojYAM55D3Lh2eClEotLKUxVqrws87aBjvibbOqOYsqjmYTaDEYwxxU" +
           "D8lAqNctJN2oXS1eYGXMRRBbManQDiLEqy629EZSzY7EzqFy0COr1WGsChXN" +
           "wfxxUplmGJS4vZkbV1d8A9fmKmYsq4OQZIUZ26sIIhVuV4GQYDiOaW3eTRZc" +
           "Evouag+qC72/JLim1pgTCianId5rIH7fm2lCY7XCYVetYNgW7ND5eQCVa5Be" +
           "IzYyDLcmYbuuzhINjYYQLhNMxk3pTYh2R53WmsGSReDjijGxoXFGVKjRuiIv" +
           "hbnSpFUqUNpJd2R1J8GEDuD2RkEEaxv7BK+hgTKRMHTSk9PIRIVK32hFY0ZU" +
           "k4yt1ddVcYB3R+zW0ipoZUE2KKbWDUZeqAw28XZNV1MKH65HeFPvop3MIKpx" +
           "U2RbYmuKhlbZ8H0YjWYinE7YDUMa/a1AkuRb3pIfa/6vGztufVVxVHzlLvuL" +
           "OCTOnv/3hisH7cU1t9ecvBZ95KC9qHn//jpcGJQeut7N9eLO0Rfe9+TTRu9X" +
           "KwfXYPpR6dz+hYLDfl4Bunn8+r+Q7X7yOLzN9vvv++8PDN86f+cN3Pp95ATI" +
           "k13+Q+GZP2TeqP/i2dJNV+62XfU+wfFGTxy/0XZHYEZx4A6P3Wt76IpYi5u3" +
           "l4A4n9uL9blr/QJ14ZQfL358pw9F2eGlzDOHFap5hTOvOFHhyK3NM/llsTPn" +
           "otJdoRk1PT1emW40kvhrHtonnm1c0a4ztz7fef3RofKMMzcdp/4ooPzDPfUf" +
           "vjzUjzJ74JSyB/Pknij/CdSOitdW8hk6c/6Q3b0vld2DwG5eu2u7+3x52b3x" +
           "lLLcYZx5HbAqNYpUfX6C2etfArOCyBsBo8f2zB67UWbM8zKrnlKG5slPRqU7" +
           "LaCt+S+Mx+4s31284HApTG3XusQdFhW0L70E2sUvjWVAt7KnXXl5aO8t9Rj+" +
           "3e90Uuy6+YXxgvXbT5FIftHjzBNAIsB+6cyOSH1/y/7olL/5pSozAji/bc/9" +
           "bS+PMh/xUn9aMOmewlLMk/xH2p1GD70TBLmXw1qFPUHh5bdW5ZSyn8qTEbBW" +
           "w7yGtY5fKrP7AaN37Jm94+VnNjulrOCiRqWz1sn50l4qqzcBNvaelf3yswpO" +
           "KctvLJxZ5fdcHVMNSMehAlNd+p69ezvzKM3nvZb5fDQfAvTSPc305af5c6eU" +
           "vSdPNlHpVsMOfS88uT5uX+oq8jig9IE9tQ/cKLVT3emhS/nwKfx+IU/eD0Lp" +
           "q67TFO0PmX7gRphmwEcdvOyWl5VBGHv/VW/b7t4Q1b/09Pnb7nt69Ke7e1oH" +
           "b3Hezpdum8WOc/TViCPP5/zAnNkF/9t3L0r4BZ9PRKVHn+9lHxDwHH4pJuUX" +
           "d40/FZXuuWZjEPXlH0frfjYqXThZNyrdUnwerfcUGO2wXh6NFA9Hq/y9qHQT" +
           "qJI//rK/m7bdYnj/EcXZ7WXufr5ZOLL9eOzYvqF4Jfogxo/F/aX/Lz/Ndd/1" +
           "XO1Xd++t6Y663ea93MaXbt29Qld0mu8TXnfd3g76Otd+04/u+s3b33Cwoblr" +
           "B/hQiY9ge+TaL4nRKz8qXuva/tP7/vGbv/j0nxWXyv8/ryqAZas+AAA=");
    }
    public class AboutAction extends javax.swing.AbstractAction {
        public AboutAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            org.apache.batik.apps.svgbrowser.AboutDialog dlg =
              new org.apache.batik.apps.svgbrowser.AboutDialog(
              JSVGViewerFrame.this);
            dlg.
              setSize(
                dlg.
                  getPreferredSize(
                    ));
            dlg.
              setLocationRelativeTo(
                JSVGViewerFrame.this);
            dlg.
              setVisible(
                true);
            dlg.
              toFront(
                );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "jdfSdNBdhswQ7BDelm0d3vXadm935xvVo0MIsGnLBlqvYdeyHXokuzx+1NzK" +
           "+xoXTjeujze3dh0PKNuJPXCzs4V8F/apZ557Qet8urh30CmagI33wZHPTk62" +
           "FX7y5ttNIT9X2bUvvvzMP18evH3+ntfQlH3o1CJPi/wd4cWv0m9Wf30PuuWo" +
           "mXHdic9JpqsnWxgXfD2MfGdwopHxwMnGKArM+fEDs378xo3RG4bAmTwEto4/" +
           "1YU7c2DAg+7E5bxXoMTAimvdCfe3jXIqu8/Zg1do4sXZxQmhi0rOJOp+1v7V" +
           "twda/WPBNAYb5LVrarsoc19tb3yiZxZCdxzr4h8uvfBajwJA0Nx/3enj9sRM" +
           "/dwLF8+/8YXhX+UN8KNTrdt56Pwssqzjnadj9+c8X5+ZuS1u3/ahvPznl0Lo" +
           "4VdbXAhd2P3JVXpmy/z+ELr3hszAiNnPcdpfCaFLp2lD6Gz+e5zu18BsOzqQ" +
           "Udub4yQfCaFbAEl2+6x3IjqS/SA2HWOfmAahD1y99UJy5mReH7n2nldz7TEo" +
           "eOxEDucHyIf5Fm2PkK+pn3+Bbb/35fKnty1+1VLSNJNynodu2542HOXsIzeV" +
           "dijrXOuJH931hdsfPwSXu7YL3mXSsbU9dON+OmV7Yd4BT//gjb/31t964Vt5" +
           "U+1/ASXlDZfZHwAA");
    }
    public class OpenAction extends javax.swing.AbstractAction {
        public OpenAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            java.io.File f =
              null;
            if (org.apache.batik.util.Platform.
                  isOSX) {
                java.awt.FileDialog fileDialog =
                  new java.awt.FileDialog(
                  JSVGViewerFrame.this,
                  org.apache.batik.apps.svgbrowser.Resources.
                    getString(
                      OPEN_TITLE));
                fileDialog.
                  setFilenameFilter(
                    new java.io.FilenameFilter(
                      ) {
                        public boolean accept(java.io.File dir,
                                              java.lang.String name) {
                            java.util.Iterator iter =
                              getHandlers(
                                ).
                              iterator(
                                );
                            while (iter.
                                     hasNext(
                                       )) {
                                org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler =
                                  (org.apache.batik.apps.svgbrowser.SquiggleInputHandler)
                                    iter.
                                    next(
                                      );
                                if (handler.
                                      accept(
                                        new java.io.File(
                                          dir,
                                          name))) {
                                    return true;
                                }
                            }
                            return false;
                        }
                    });
                fileDialog.
                  setVisible(
                    true);
                java.lang.String filename =
                  fileDialog.
                  getFile(
                    );
                if (fileDialog !=
                      null) {
                    java.lang.String dirname =
                      fileDialog.
                      getDirectory(
                        );
                    f =
                      new java.io.File(
                        dirname,
                        filename);
                }
            }
            else {
                javax.swing.JFileChooser fileChooser =
                  null;
                java.lang.String os =
                  java.lang.System.
                  getProperty(
                    PROPERTY_OS_NAME,
                    PROPERTY_OS_NAME_DEFAULT);
                java.lang.SecurityManager sm =
                  java.lang.System.
                  getSecurityManager(
                    );
                if (priorJDK1_4 &&
                      sm !=
                      null &&
                      os.
                      indexOf(
                        PROPERTY_OS_WINDOWS_PREFIX) !=
                      -1) {
                    fileChooser =
                      new javax.swing.JFileChooser(
                        makeAbsolute(
                          currentPath),
                        new org.apache.batik.apps.svgbrowser.WindowsAltFileSystemView(
                          ));
                }
                else {
                    fileChooser =
                      new javax.swing.JFileChooser(
                        makeAbsolute(
                          currentPath));
                }
                fileChooser.
                  setFileHidingEnabled(
                    false);
                fileChooser.
                  setFileSelectionMode(
                    javax.swing.JFileChooser.
                      FILES_ONLY);
                java.util.Iterator iter =
                  getHandlers(
                    ).
                  iterator(
                    );
                while (iter.
                         hasNext(
                           )) {
                    org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler =
                      (org.apache.batik.apps.svgbrowser.SquiggleInputHandler)
                        iter.
                        next(
                          );
                    fileChooser.
                      addChoosableFileFilter(
                        new org.apache.batik.apps.svgbrowser.SquiggleInputHandlerFilter(
                          handler));
                }
                int choice =
                  fileChooser.
                  showOpenDialog(
                    JSVGViewerFrame.this);
                if (choice ==
                      javax.swing.JFileChooser.
                        APPROVE_OPTION) {
                    f =
                      fileChooser.
                        getSelectedFile(
                          );
                    currentPath =
                      f;
                }
            }
            if (f !=
                  null) {
                try {
                    java.lang.String furl =
                      f.
                      toURL(
                        ).
                      toString(
                        );
                    showSVGDocument(
                      furl);
                }
                catch (java.net.MalformedURLException ex) {
                    if (userAgent !=
                          null) {
                        userAgent.
                          displayError(
                            ex);
                    }
                }
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8zk1lX3frubbLZpdpM2aRqa96aQTPV53p5h+5rx2GPP" +
           "2J6X52FDu/XjeuwZvx/jGZdAGkRbKGojSEuR2vzVQonShxAVSKgoCEFbtUIq" +
           "qnhJtBVColAqmj8oiALl2vN933zft7uJIiRGmjue63POvefcc3733HNf+D5y" +
           "PvCRnOuYm7nphPtgHe4vzMp+uHFBsN9hKn3JD4CKm1IQ8LDvmvLIFy798EfP" +
           "6Jf3kFtE5HWSbTuhFBqOHQxB4JgroDLIpV0vYQIrCJHLzEJaSWgUGibKGEF4" +
           "lUFec4w1RK4wh1NA4RRQOAU0mwLa2FFBptcCO7LwlEOyw8BDfh45wyC3uEo6" +
           "vRB5+KQQV/Il60BMP9MASriQ/p9ApTLmtY88dKT7VufrFP5oDn32N959+XfP" +
           "IpdE5JJhj9LpKHASIRxERG63gCUDP2ioKlBF5E4bAHUEfEMyjSSbt4jcFRhz" +
           "WwojHxwZKe2MXOBnY+4sd7uS6uZHSuj4R+ppBjDVw3/nNVOaQ13v2em61ZBM" +
           "+6GCFw04MV+TFHDIcm5p2GqIPHia40jHK11IAFlvtUCoO0dDnbMl2IHctV07" +
           "U7Ln6Cj0DXsOSc87ERwlRO67qdDU1q6kLKU5uBYi956m629fQarbMkOkLCFy" +
           "92myTBJcpftOrdKx9fk+99YPv9em7L1szipQzHT+FyDTA6eYhkADPrAVsGW8" +
           "/QnmY9I9X/rgHoJA4rtPEW9pfv/nXnrnWx548Stbmp+4AU1PXgAlvKZ8Sr7j" +
           "G2/CH6+fTadxwXUCI138E5pn7t8/eHN17cLIu+dIYvpy//Dli8M/E556Hnxv" +
           "D7lII7cojhlZ0I/uVBzLNUzgt4ENfCkEKo3cBmwVz97TyK3wmTFssO3taVoA" +
           "Qho5Z2ZdtzjZf2giDYpITXQrfDZszTl8dqVQz57XLoIgr4Ff5DKCnPstJPts" +
           "f0NEQXXHAqikSLZhO2jfd1L9AxTYoQxtq6My9PolGjiRD10Qdfw5KkE/0MHB" +
           "C8l1AzRYzWXfiQPgo53RpD0xQAx8EoYr2E+dzf3/GWadans5PnMGLsSbTsOA" +
           "CSOIckwV+NeUZ6Mm8dLnrn1t7ygsDuwUIlfhyPvbkfezkffTkfd3I++fGvlK" +
           "zwV2Q0lXGTlzJhv79elktg4Al28JgQBC5O2Pj97Vec8HHzkLPc+Nz0Hbp6To" +
           "zZEa30EHnQGkAv0XefHj8fsmv5DfQ/ZOQm6qAOy6mLL3U6A8AsQrp0PtRnIv" +
           "feC7P/z8x550dkF3AsMPsOB6zjSWHzltat9RgArRcSf+iYekL1770pNX9pBz" +
           "ECAgKIYSdGKINw+cHuNETF89xMdUl/NQYc3xLclMXx2C2sVQh+uy68l84I7s" +
           "+U5o40upk78RevtnDrw++03fvs5N29dvfSZdtFNaZPj7tpH7yb/+838qZeY+" +
           "hOpLxza/EQivHoOHVNilDAju3PkA7wMA6f7u4/1f/+j3P/AzmQNAikdvNOCV" +
           "tMUhLMAlhGb+pa94f/Ptb33qm3s7pwnh/hjJpqGsj5S8kOp0x8soCUd7824+" +
           "EF5MkDlscGVsW45qaIYkmyD10v+69Fjhi//y4ctbPzBhz6EbveWVBez639hE" +
           "nvrau//9gUzMGSXd3nY225FtMfN1O8kN35c26TzW7/uL+3/zy9InIfpCxAuM" +
           "BGQghmQ2QLJFQzP9n8ja/VPvCmnzYHDc+U/G17E05JryzDd/8NrJD/7opWy2" +
           "J/OY42vNSu7VrXulzUNrKP4NpyOdkgId0pVf5H72svnij6BEEUpUIKQFPR9i" +
           "z/qEZxxQn7/1b//4T+55zzfOInskctF0JJWUsiBDboPeDQIdwtbafcc7t6sb" +
           "X9gCOVQVuU75rVPcm/07Cyf4+M3xhUzTkF2I3vufPVN++u//4zojZMhyg933" +
           "FL+IvvCJ+/C3fy/j34V4yv3A+no8hinbjrf4vPVve4/c8qd7yK0iclk5yAcn" +
           "khmlgSPCHCg4TBJhznji/cl8Zrt5Xz2CsDedhpdjw54Gl90+AJ9T6vT54nE8" +
           "+TH8nIHf/0m/qbnTju0uehd+sJU/dLSXu+76DIzW88V9bD+f8r8jk/Jw1l5J" +
           "m5/cLlP6+FMwrIMsEYUcmmFLZjbwO0PoYqZy5VD6BCamcE2uLEwsE3M3TMUz" +
           "d0q1399mc1tAS9tiJmLrEpWbus9Pb6myneuOnTDGgYnhh/7hma9/5NFvwzXt" +
           "IOdXqb3hUh4bkYvSXPn9L3z0/tc8+50PZSgFIWry1GP/mmUezMtpnDZE2pCH" +
           "qt6XqjrKMgBGCkI2AxagZtq+rCv3fcOC+Ls6SATRJ+/69vIT3/3sNsk77ben" +
           "iMEHn/2VH+9/+Nm9Y6n1o9dlt8d5tul1NunXHljYRx5+uVEyDvIfP//kH37m" +
           "yQ9sZ3XXyUSRgOegz/7lf399/+Pf+eoNspJzpvN/WNjw9jxVDujG4YcpCNo0" +
           "VobrqRZhrFrEyHqos5jEV5U11cZtYlTC+WFDlaixAkpEebrRyuEA13PCJkzC" +
           "UohSALPEUmFRxdqc2+122zjRmJZawqLKVMDUa+e9YWNMT3Vz4nj57gjPD8dk" +
           "k+/0y3ONGOQHhos2cX0l2uKqjsrBsEf0ed+vW5SdlPzNqlSKkqRQoEJZIiNH" +
           "7xElvt2hRGPQVV2ZM4mqCmJ5mGsFQlITGwlaro0Ky1lkeO0yHg5HcX+0Xljx" +
           "xhuS/QCXh2JhWuyqoi3Q5YEjEzOJXkhrd9GctGZ5XJUWxTFHjSekZcZlEW+z" +
           "RDk0u05rwnnexKKWRnvWGE/lMdbgDVAnqvOw3yn0nBEvs22xXtMEvNZPWq0u" +
           "HeWYTmQUwoHbp8emXvUkk+yElrEWJUZ1pRZXSaRGZ+x1O+O6myvEQ2q8inye" +
           "a9WF1aZl5RTGV2NCwvCoXRn54rpmhh7JEaMpWV5hzpyQunXLzg+HQ8ZRx03B" +
           "catjtzLAhWGX5ni+4AG8xCt8aWQX24VYrdptjy1Oi7TgFSc8vQ6EKcO4Qb6U" +
           "cLHXBRFmx2uJiQp+tzQIlj65LqlMLZ8DUr8AWuzYHpPJZF3XiyI3J5ojghfI" +
           "5ihpMgxmsmNnuZlzelHpj4WAnK48v7dyVXPFVSvzapnC+kw7GbCCTYqaV2ws" +
           "crjsCotxjfW8irZogGmuAIS8DY/XvVJB1QWpJTfjsUwOdaEg9Ab1TWVUdKzJ" +
           "pKhLRFgeTuBJMKg1GqO1OhmN8kJnSBbAXGiaOIY3Ca5aMt0W0eknMef6A6Ip" +
           "ke28MJ5aCSdYpqGubWsoDGnZyVt012t6ZVqdj4yFj4udmAdts7UhgiZaiLXe" +
           "rBXRWjGmluNhkeFwkS6FWjIOqnMn7C3dzRrvDprFjp6vYmMCWyQVmRvqNF6m" +
           "84NAorBYH65KGDAlYJYGMrlpi4shZgTzPL2pW9M6JhW4OsaX16FTL+flzriy" +
           "yncS25q46kYU2Tmp94JAKU553CrE1Zzf7/dnmw7amnbbjjqwp2uH1ynDI/JF" +
           "w5M8AgSDvGCR3Um7PW70h+asnOuXh9N4xnULwlKglJIpE11qTJfaes5h0XnZ" +
           "2swJRvQ6bUDKBbtH1K3KfJqj+p1hwwj1Rd0bSgurV16g607emI4cYTjq6G0Q" +
           "efJSdzfFVrW4pue8LgbTCr4h+lN+aeXLpDOai6RewcesQtJzbD4u8Wa0cTVO" +
           "2LhzgnNH3KJc1toTvsP5BElPKp15PJVzWm00thjRdw12qLAji22snSXRplrj" +
           "vD5ZSkCNy70SNddrVYFmRWHqu3ln5DBLvYMr5Q7N8xSDm5WYHoGyyAk26CTs" +
           "yskbxKaAMZzB4g0uLuFj6DJcMu6h8nwpcnZUZAcAiPmWaoDlTJxNusMctcnX" +
           "DBalzXoki5iqljQVRtx0OW5FU09gCxOrVfVb64aZJK5oqzxpeZNZ0i02l07b" +
           "K02n9JAliXZk5iNy4/HAMthZuztx5HKvMeE6UjUf+CYcuu5Up0y+nGO1orki" +
           "ibHvxQN+Ogga64pkt2VpxsqxvWhgTE0oapEmNysjzWo1a3Y38HqTTdGfLGg1" +
           "CvpDghf7w7BaIOXcGMysSK9E9cYMV4QA2p41ooCOu23CrS7ZSt4bAFIpi5N1" +
           "05NrVqKMGsFgtCrTrXpQRP14GhtMr7aioxHXtEtj3lQTWZZkxu/plMWwFXy6" +
           "wkc1abmuVW0NXTF9Kte36p7L9LnGdNFsSy28IQl1uRdIK4hg4YI0yEY9BzeS" +
           "lgJgJFg9ui46nJGz2QY8CuapToOdzV0LhTupq9arWGTPzWqgVHSRicQukXTd" +
           "6cRvK9VQXeMjES/m67U+3YX+SmNif4A6RKfu8cFEXMgtImeqtTVWnaG2FE2U" +
           "UbNpcKDdK1b6Aw5Fu9VWNd0x0E1iYL3OphsbuURONgOe9VGiUi8sp7ZFYd1W" +
           "aVOPxNXKkbS5QzfpdtEPyvyCiejigFu7OczOAdQuYGFL6dR1U1/nWTTwa7g9" +
           "7LU1u2ZqQF7X62hlIGvydOaTGl9gWxJP+4kgTpVOsVtj5nVOl5uggUVVc6nk" +
           "StIyKM0BSyidQVMHhSGewzeTJiEy9iz0QrRe52a9ZRElx9RgwE2d9mQurPmE" +
           "GTc4ksMa9FxW7FqdKuFRvV9wVlLD8/RuTnKaYtQIN1gYOW19JEeJSFUxDHVI" +
           "m/SwTbfFkotyoanrUIl6yQQ9NlkAyiPLmxI+L0+L/no0r3VlrzahKmswzkta" +
           "yeAlYyUzTivf7OfQzQpFS8maHUM3IFldMpN2fq3ReEBYm6Ab881ViYpj4Gtm" +
           "rNfRQodFAa4U5nShAJHQLGrBNN9uzSAggFLg+gu0YsYYieEbbdVgqyW9HYvi" +
           "ylbL8NjfY4b8Sm+ZM8lt1Dw/Cu3OkLX0CdF2hhKrFlxDkCUgrFdYfjRe1Loz" +
           "H12CFTqquXiV7+Hj+dQzXak9XvhzIALUd0TUUoSNHctNPmF7xnioz5NCYgWT" +
           "YB5bmigOB6P2iiMlfk4O8LyOL4cMtin21I4oNdu4prihIUlYfaWYq1kpBMO2" +
           "V57H5eES6yeLUlHotZSVYwoKi4kzVfObHOg6MXSHrpUUaS02av1aP5dwapFu" +
           "Opy6wkqzSknCbF2UTd+ZFktFXZixMNfflFhUs+WI50aFZNTuShB8JuI67AfL" +
           "SBKp0karDZW63rALluFx1KqSxDbml3hbb46nZr3Qak6oDmqR+mxRj5wxpQUc" +
           "H802NUnoLpOWJZHOwhWoZGYN5Y43SZKOQ9kdv84NPK4U1YpNiAvMJGeNp40N" +
           "ZQkVkyxzYXFUoEHFMwqLRjiUZzXKGy1otmg3YB7UyrdHkuAaA5YGDeC1wKTT" +
           "LXJcTBGlvCiR9rzamM0MnfTCtgqwZKHq5X7ct4sG3MVma7rGUgwRxkMnbILe" +
           "orWG0Mj1jVqlU1i1AqZVr8RLUuIo0hxwUZFegP6kXtJLbhAyiRzUet0CP00E" +
           "vWJx8zG/atQa8VSdydBHfKxT2ago1Ss75Eyz20XMKtAJYJ25YUpKso4XOqAm" +
           "kc5R3flyXeByzMCsGYCp8z5Tmib9EhbYdVQDNYXxCmK936037cpmwfbRyMdz" +
           "y5ljFIS+M3Hp4aQrDeiip2kQ012eHtcFQjLlcD7sBIRsONNmiNeFamTbMr3s" +
           "dHBmtIGEq3bcKxmW36v0Wb8qO17V27StnD/A+YG0LOSpFsySe7VJs4Z22l1+" +
           "vQb8rMmyGN+gNhamWMUCptsV1EMJrdTN9XmB7k08nXdb9W646phRyNW6ETUr" +
           "N6UimBAjoakxHVbilvl+q91ny9Okyo6p1tqwuhjVoRqVKbGaVbkADTytOIKh" +
           "VJuxK6+vcg24czbelh4d3vXqTm93ZgfVozsIeGhLX1Cv4tSyffVw2jx2VNzK" +
           "6hoXT9etjxe3dhUPJD2J3X+zq4XsFPapp599Tu19urB3UCmawYP3wY3PTk56" +
           "FH7i5sdNNrtW2ZUvvvz0P9/Hv11/z6soyj54apKnRf4O+8JX229Wfm0POXtU" +
           "zLjuwuck09WTJYyLPggj3+ZPFDLuP1kYLUJzPn9g1udvXBi9oQucyVxgu/Cn" +
           "qnBnDgx4UJ24L6sVSDG04grY4f62UE6kzxl78DJFvDht7BC5JGVMfbjHOL4F" +
           "tvdZo2PONIUH5JVjqDsvc17pbHyiZhYiF3dF/MOZ51/tRQD0mXuvu3vc3pcp" +
           "n3vu0oU3PDf+q6z+fXSndRuDXNAi0zxeeDr2fIvrA83ITHHbtgzlZj+/GCIP" +
           "vdLkoEq7P5lKT2+Z3x8id9+QGdow/TlO+8shcvk0bYicz36P0/0qHG1HBwNq" +
           "+3Cc5CMhchaSpI/PuCecY70fxIY932/IQejDld6uwvrMybA+Wtm7XmlljyHB" +
           "oydCOLs+Pgy3aHuBfE35/HMd7r0vVT+9rfArppQkqZQLDHLr9rLhKGQfvqm0" +
           "Q1m3UI//6I4v3PbYIbbcsZ3wLpCOze3BG5fTCcsNswJ48gdv+L23/vZz38pq" +
           "av8LF4E/hNcfAAA=");
    }
    public void showSVGDocument(java.lang.String uri) {
        try {
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              uri);
            org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler =
              getInputHandler(
                purl);
            handler.
              handle(
                purl,
                JSVGViewerFrame.this);
        }
        catch (java.lang.Exception e) {
            if (userAgent !=
                  null) {
                userAgent.
                  displayError(
                    e);
            }
        }
    }
    public org.apache.batik.apps.svgbrowser.SquiggleInputHandler getInputHandler(org.apache.batik.util.ParsedURL purl)
          throws java.io.IOException { java.util.Iterator iter =
                                         getHandlers(
                                           ).
                                         iterator(
                                           );
                                       org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler =
                                         null;
                                       while (iter.
                                                hasNext(
                                                  )) {
                                           org.apache.batik.apps.svgbrowser.SquiggleInputHandler curHandler =
                                             (org.apache.batik.apps.svgbrowser.SquiggleInputHandler)
                                               iter.
                                               next(
                                                 );
                                           if (curHandler.
                                                 accept(
                                                   purl)) {
                                               handler =
                                                 curHandler;
                                               break;
                                           }
                                       }
                                       if (handler ==
                                             null) {
                                           handler =
                                             defaultHandler;
                                       }
                                       return handler;
    }
    protected static java.util.Vector getHandlers() {
        if (handlers !=
              null) {
            return handlers;
        }
        handlers =
          new java.util.Vector(
            );
        registerHandler(
          new org.apache.batik.apps.svgbrowser.SVGInputHandler(
            ));
        java.util.Iterator iter =
          org.apache.batik.util.Service.
          providers(
            org.apache.batik.apps.svgbrowser.SquiggleInputHandler.class);
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler =
              (org.apache.batik.apps.svgbrowser.SquiggleInputHandler)
                iter.
                next(
                  );
            registerHandler(
              handler);
        }
        return handlers;
    }
    public static synchronized void registerHandler(org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler) {
        java.util.Vector handlers =
          getHandlers(
            );
        handlers.
          addElement(
            handler);
    }
    public class OpenLocationAction extends javax.swing.AbstractAction {
        public OpenLocationAction() { super(
                                        );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (uriChooser ==
                  null) {
                uriChooser =
                  new org.apache.batik.util.gui.URIChooser(
                    JSVGViewerFrame.this);
                uriChooser.
                  setFileFilter(
                    new org.apache.batik.swing.svg.SVGFileFilter(
                      ));
                uriChooser.
                  pack(
                    );
                java.awt.Rectangle fr =
                  getBounds(
                    );
                java.awt.Dimension sd =
                  uriChooser.
                  getSize(
                    );
                uriChooser.
                  setLocation(
                    fr.
                      x +
                      (fr.
                         width -
                         sd.
                           width) /
                      2,
                    fr.
                      y +
                      (fr.
                         height -
                         sd.
                           height) /
                      2);
            }
            if (uriChooser.
                  showDialog(
                    ) ==
                  org.apache.batik.util.gui.URIChooser.
                    OK_OPTION) {
                java.lang.String s =
                  uriChooser.
                  getText(
                    );
                if (s ==
                      null)
                    return;
                int i =
                  s.
                  indexOf(
                    '#');
                java.lang.String t =
                  "";
                if (i !=
                      -1) {
                    t =
                      s.
                        substring(
                          i +
                            1);
                    s =
                      s.
                        substring(
                          0,
                          i);
                }
                if (!s.
                      equals(
                        "")) {
                    java.io.File f =
                      new java.io.File(
                      s);
                    if (f.
                          exists(
                            )) {
                        if (f.
                              isDirectory(
                                )) {
                            s =
                              null;
                        }
                        else {
                            try {
                                s =
                                  f.
                                    getCanonicalPath(
                                      );
                                if (s.
                                      startsWith(
                                        "/")) {
                                    s =
                                      "file:" +
                                      s;
                                }
                                else {
                                    s =
                                      "file:/" +
                                      s;
                                }
                            }
                            catch (java.io.IOException ex) {
                                
                            }
                        }
                    }
                    if (s !=
                          null) {
                        if (svgDocument !=
                              null) {
                            org.apache.batik.util.ParsedURL docPURL =
                              new org.apache.batik.util.ParsedURL(
                              svgDocument.
                                getURL(
                                  ));
                            org.apache.batik.util.ParsedURL purl =
                              new org.apache.batik.util.ParsedURL(
                              docPURL,
                              s);
                            java.lang.String fi =
                              svgCanvas.
                              getFragmentIdentifier(
                                );
                            if (docPURL.
                                  equals(
                                    purl) &&
                                  t.
                                  equals(
                                    fi)) {
                                return;
                            }
                        }
                        if (t.
                              length(
                                ) !=
                              0) {
                            s +=
                              '#' +
                              t;
                        }
                        showSVGDocument(
                          s);
                    }
                }
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "fuv5b+X1tf8FPph+oOsfAAA=");
    }
    public class NewWindowAction extends javax.swing.AbstractAction {
        public NewWindowAction() { super(
                                     ); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            org.apache.batik.apps.svgbrowser.JSVGViewerFrame vf =
              application.
              createAndShowJSVGViewerFrame(
                );
            vf.
              autoAdjust =
              autoAdjust;
            vf.
              debug =
              debug;
            vf.
              svgCanvas.
              setProgressivePaint(
                svgCanvas.
                  getProgressivePaint(
                    ));
            vf.
              svgCanvas.
              setDoubleBufferedRendering(
                svgCanvas.
                  getDoubleBufferedRendering(
                    ));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "FAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/lt5ce1/AULmQkLlHwAA");
    }
    public class PreferencesAction extends javax.swing.AbstractAction {
        public PreferencesAction() { super(
                                       );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            application.
              showPreferenceDialog(
                JSVGViewerFrame.this);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "6LSmzRidUklwRMiODu94dae3u/OD6tFVBDi0ZS+oV3Fq2b56NBueOGpu5X2N" +
           "i6fb18ebW7uOB5SdxB681Q1Dfgr71DPXn1cGny7tHXSKpuDgfXDxs6OTHYWf" +
           "uvVxs5ffruzaF19+5p8fGL1Vf9eraMo+fIrJ0yR/p/fCV9tvkn99Dzp71My4" +
           "4d7nJNLVky2Mi74aRr4zOtHIePBkYxQB6nzuQK3P3bwxelMXOJO7wNbwp7pw" +
           "Zw4UeNCdeCDvFYgJ0GKsOuH+tlHeyp5z9OBlmnhJNjghdEnMkVjVz9q/6vZa" +
           "iz/mTBNwQI5dQ9l5mftKZ+MTPTPguzf08g8FKL7aawHgOvffcBO5vT2TP/f8" +
           "pQtveH78V3kb/OiG6w4GurCILOt4/+nY83kP8GbkGrlj243y8p/3hdAjr8Rc" +
           "CF3c/clFemaL/P4QuvemyECV2c9x2F8JocunYUPoXP57HO7XwGo7OBBX24fj" +
           "IB8JobMAJHt81jvhI+l+kBiOtl+XgtAHBt9aIT1zMrqPDHzPKxn4WEJ4/EQk" +
           "55fJh1EXba+Tr8mff77Tf/dL1U9vG/2yJW42GZULDHT79s7hKHIfvSW1Q1rn" +
           "qSd/dNcX7njiMMXctWV4F0/HeHv45l31lu2FeR988wdv+L23/Nbz38pba/8L" +
           "P4xbLuUfAAA=");
    }
    public class CloseAction extends javax.swing.AbstractAction {
        public CloseAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            application.
              closeJSVGViewerFrame(
                JSVGViewerFrame.this);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Y6EotcEoXZtYkVDcpWP4JW29SdRiS0B6Ix3BYHE1LHZHq8kktcKqjNcCFa0h" +
           "hXrZbtYWU00m563eiJ4LiNnqjYsbJlhLA6SDp8M+n/IDza1axLiHbjaLTT0t" +
           "YcioMmeC/pKnVqqld1ox7lD8qCX0zGaysIdGEKJ0i4mKpWQwgEG+M54Uq5W5" +
           "MXYjZ8q0q8MUc5KGleol0mvN7dUQ4fx5NV5NNL8xLJUwKmxidIOEgRFgI54P" +
           "9FYtFflWWCDkWeRWZkpVEAZRGAZcB2fKbmO9YdZpEaYiX6hqrQ4nD7u9ZaVs" +
           "l3pzs7+qr9eNsdTU0HXRMjyMGCGEqZSJyJ6zhBP2CJ3EnOEEJmkdJoQmvy7D" +
           "FdGWIgtFYm1hzacIPcan8Qhb99kSy4m2txrRo8m8Ji6N+lp2o5U3qMIV1pPb" +
           "zlobDoaFikXGtB90hGlzUmz1LFfQhXIFqLM3qcpkq1TRO2TfGIzx9oonS61m" +
           "v9PtYfOgi3ssBS9jRBzjxRg4GIvNGlJVKZcbdROdpCo4/xO4E2EaIgwLlIPa" +
           "qqgbcpsQy6neldu1zdhTrMLAnqRaT9/UIq27ErlobjUEpwrkTQvSrEZwdTR0" +
           "nEEh1dP+AndhHuUpPazbQrcQRxWQtqlrulWsVMeyLTRr3TK+GZKuroeShFNl" +
           "MxHJuZWQHVZapW6nyqDhZqU0mEmRAXeMtFoPymWY6dVkUcWFcOIWZn6a1uNe" +
           "IxI7OpZ4mtbtcDjt0jrVc+d1NbSawqBt+7w1XQw8PFloeqPVSWQn9mwOaQJF" +
           "aO7UECwxWcnmvGVV5sVqMnA5YqZ0mOmcNxJTkrgaTi7Xo4qw8oAPkapXqRSm" +
           "qjKJdYdaWV67AxsrylQCT57CdLOMFGGXSUWxrW0G7Y3M0yBCaUPXHMfLsNGE" +
           "UX8a6xVbX9JNPrINvWvWhJbm99vzgNm4TgnXOgZXjoQeNg0GyloqL9RKBQ4a" +
           "ThlGPW4syCnbAVeE7Orw9ld3e7snv6gePUIAhWYTxKu4tWynHs2aJ46KW3ld" +
           "4+LpwvXx4tau4gFlN7EHb/W2kN/CPvnMc8/Lw08V9w4qRXNw8T548tnRya7C" +
           "T936utnP31V25YsvPfPPVyZv0d75KoqyD59i8jTJ3+m/8JXuG6Vf24POHhUz" +
           "bnjxOYl07WQJ46KvhJFvT04UMh48WRgtAXV+4kCtn7h5YfSmLnAmd4Gt4U9V" +
           "4c4cKPCgOnElrxUIMdDiWrHD/W2hvJ31c/TgZYp4cdbYIXRJyJEYxc/Kv8r2" +
           "QYs95kwzcEFeO7q88zLnle7GJ2pmIXTnsSr+IevIq30KAE7zwA2vj9sXM+mz" +
           "z1+68Prnp3+VF8CPXrXuoKELamSaxytPx/rnXV9R9VwXd2zrUG7+84sh9Mgr" +
           "MRdCF3d/cpGe2SK/N4TuuykyUGL2cxz2l0Po8mnYEDqX/x6H+1Ww2g4O7Kht" +
           "5zjIh0LoLADJus+6J7wj2Q9i3V7uo2IQ+sDUWyskZ07u6yPT3vtKpj0WCh4/" +
           "sYfzB+TD/RZtn5CvS597nhq866Xap7YlfskU0jSjcoGGbt++Nhzt2UdvSe2Q" +
           "1nniyR/e/fk7njgMLndvGd7tpGO8PXzzenrbcsO8Ap7+wet/782/9fw386La" +
           "/wLGYPQT2R8AAA==");
    }
    public class ReloadAction extends javax.swing.AbstractAction {
        public ReloadAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if ((e.
                   getModifiers(
                     ) &
                   java.awt.event.ActionEvent.
                     SHIFT_MASK) ==
                  1) {
                svgCanvas.
                  flushImageCache(
                    );
            }
            if (svgDocument !=
                  null) {
                localHistory.
                  reload(
                    );
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwcRxWfu7Md27F9thM7IYmdxHGC8qHbBBqgclrquHbi" +
           "cLZPdmqBQ3OZ252723hvd7M7a59dDG0llLSCEAW3TSvqv1ylQW1TISpA0Mqo" +
           "Em1VQGqJgIKaIvEH4SOiEVL5I0B5M7N7u7dnJwp/cNLtx8yb9+Z9/d6bfeE6" +
           "qrYt1El0mqAzJrET/TpNYcsmSp+GbfsojKXlp2L4H8evDd8dRTUTqCmP7SEZ" +
           "22RAJZpiT6AOVbcp1mViDxOisBUpi9jEmsJUNfQJ1KbagwVTU2WVDhkKYQTj" +
           "2EqiFkyppWYcSgZdBhR1JGEnEt+J1Bue7kmiBtkwZ3zy9QHyvsAMoyz4smyK" +
           "mpMn8RSWHKpqUlK1aU/RQrtNQ5vJaQZNkCJNnNT2uyY4ktxfYYKul+Mf3TyX" +
           "b+YmWIN13aBcPXuU2IY2RZQkivuj/Rop2KfQV1EsiVYHiCnqTnpCJRAqgVBP" +
           "W58Kdt9IdKfQZ3B1qMepxpTZhijaWs7ExBYuuGxSfM/AoZa6uvPFoO2WkrZC" +
           "ywoVn9gtzT91vPl7MRSfQHFVH2PbkWETFIRMgEFJIUMsu1dRiDKBWnRw9hix" +
           "VKyps66nW201p2PqgPs9s7BBxyQWl+nbCvwIulmOTA2rpF6WB5T7Vp3VcA50" +
           "bfd1FRoOsHFQsF6FjVlZDHHnLqmaVHWFos3hFSUdu78ABLB0VYHQvFESVaVj" +
           "GECtIkQ0rOekMQg9PQek1QYEoEXRhhWZMlubWJ7EOZJmERmiS4kpoKrjhmBL" +
           "KGoLk3FO4KUNIS8F/HN9+MDZh/TDehRFYM8KkTW2/9WwqDO0aJRkiUUgD8TC" +
           "hl3JJ3H7q2eiCAFxW4hY0PzgKzfu29O59Kag2bgMzUjmJJFpWl7MNL2zqW/n" +
           "3TG2jVrTsFXm/DLNeZal3JmeogkI017iyCYT3uTS6M++9PB3yV+jqH4Q1ciG" +
           "5hQgjlpko2CqGrEOEZ1YmBJlENURXenj84NoFTwnVZ2I0ZFs1iZ0EFVpfKjG" +
           "4O9goiywYCaqh2dVzxres4lpnj8XTYTQavijZoSqLyL+E3eKZClvFIiEZayr" +
           "uiGlLIPpb0uAOBmwbV7KQNRPSrbhWBCCkmHlJAxxkCfuBDZNW7KnchnLmAY0" +
           "lI6MjR8aV8k0sQYgXUmCBZv5/xFTZNqumY5EwBGbwjCgQQYdNjSFWGl53jnY" +
           "f+Ol9NsixFhauHai6B6QnBCSE1xygklO+JITIcndo0QzsNIrMz+jSIRLX8u2" +
           "I0IAHDgJUABY3LBz7MEjJ850xSD2zOkqsD4j7SqrSX0+Xnggn5YvtzbObr26" +
           "7/UoqkqiVixTB2usxPRaOQAvedLN74YMVCu/aGwJFA1W7SxDJgpg1krFw+VS" +
           "a0wRi41TtDbAwStpLHmllQvKsvtHSxemHxn/2t4oipbXCSayGiCOLU8xdC+h" +
           "eHcYH5bjGz997aPLT84ZPlKUFR6vXlasZDp0heMjbJ60vGsLfiX96lw3N3sd" +
           "IDnFkHkAkp1hGWVA1OOBOtOlFhTOGlYBa2zKs3E9zUMw+SM8cFv481oIizjL" +
           "zI2Qos+7qcrvbLbdZNd1ItBZnIW04EXjnjHz2d/+8s+f5ub26ks80BiMEdoT" +
           "wDTGrJWjV4sftkctQoDu/Qupbz9x/fQxHrNAsW05gd3s2gdYBi4EM3/9zVPv" +
           "fXB18UrUj3MKRd3JQG9ULClZy3RquoWSIG2Hvx/ARI3wHLO7H9AhPtWsijMa" +
           "YYn1r/j2fa/87WyziAMNRrww2nN7Bv74Jw6ih98+/s9OziYis5rs28wnE0C/" +
           "xufca1l4hu2j+Mi7HU+/gZ+FkgEwbauzhCMv4jZA3Gn7uf57+fWu0Nxn2WW7" +
           "HQz+8vwK9E5p+dyVDxvHP3ztBt9tefMV9PUQNntEeLHLjiKwXxcGp8PYzgPd" +
           "XUvDX27Wlm4CxwngKAMO2yMWAGaxLDJc6upVv/vp6+0n3omh6ACqZxA4gHmS" +
           "oTqIbmLnAWuL5ufvE96drhXVB1RFFcpXDDADb17edf0Fk3Jjz/5w3fcPXFy4" +
           "yqPMFDw2Bhl+kl12l+KNz9SH618w3so4WKhjpRaFt1eLj84vKCPP7RONRGt5" +
           "2e+HrvbFX//754kLf3hrmRpT47aYvkBWCDrKCsEQb918MHq/6fwff9SdO3gn" +
           "NYCNdd4G5dn7ZtBg18qYHt7KG4/+ZcPRe/Mn7gDON4dsGWZ5aeiFtw7tkM9H" +
           "eZ8qkLyivy1f1BO0Kgi1CDTkOlOTjTTymN9WDqmfAq9fcr1/aXlIXSZwSkC1" +
           "0tJQSkdcj7L39dBR8zjG02DYKeZh0Sj0s2cu8+gtEOGL7DICCY35ohScA6CW" +
           "EAWiZectDnWWWgBgn3LbYmmu9YPJ71x7UURquIcOEZMz849/nDg7L6JWHDS2" +
           "VfT6wTXisMG32yxs9jH8IvD/D/szXdiAaDZb+9yOd0up5WW5a6Gtt9oWFzHw" +
           "p8tzP35+7nTUtc0hiqqmDFWcbj7HLimR9z3/I+awgV6zSFFDsKPz3Lj3TvtC" +
           "UGp9xVFUHJ/klxbitesWHvgNT+bSEacB0jLraFogqoMRXmNaJKty3RsEopv8" +
           "Ngmt3u02R1G9/8JVOikWw4GmbdnFYF12C9Keoqg5TEtRNb8H6ShI8+kA7sRD" +
           "kGSaohiQsEcA+2CmFBP2NBxJE70Z6Nog7IUXipFKfOc+b7udzwOAvq0sZfjX" +
           "BA+OHPE9AVrthSPDD934zHOid5I1PDvLT59wmBZtXAnStq7IzeNVc3jnzaaX" +
           "67Z7EdsiNuwDzcZAqvcCZJis7m0INRZ2d6m/eG/xwGu/OFPzLiTnMRTBFK05" +
           "FjjLi4MrdCcO1JJjSb+aBL5G8Y6nZ+czM/fuyf7997x0utVn08r0afnKxQd/" +
           "dX79InRGqwdRNSQjKU6getW+f0YfJfKUNYEaVbu/CFsELirWBlGto6unHDKo" +
           "JFETi2/MvjNwu7jmbCyNss6boq5KkKk8r0CbAel10HB0hYM8lB9/pOwzh1cV" +
           "HNMMLfBHSq5cW6l7Wr7/sfhPzrXGBiBHy9QJsl9lO5lSxQl++fBLUDO7HC8K" +
           "+Iulk0Om6cFhrMoUsf+4oGHjFEV2uaOBWsJev8nZfYM/ssu3/guecaan1BQA" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "PuXgMIxLsBFriiy7CDEAl4Qnn8yuD29/ZTe4O/PL6tFLBLi4ZR3MK7i5bLse" +
           "zorHjhJceW7j4uns9fEE1y7rAWW3sftv9sCQ38Q++fSzz6m9TyF7B9miCbh8" +
           "H7z77ORk1+Enbn7l5PLHlV0K46tP//N9wlvm73wFidkHT03ytMjPcs9/vflG" +
           "5Tf3oLNHCY3rnn1OMl09mca4GGhRHLjCiWTG/SeToygw52cPzPrZGydHb+gC" +
           "Z3IX2C78qUzcmQMDHmQo7svzBXICrLjS3Gh/myynsnrOHr5EIi/JCjeCLsk5" +
           "U18LshSwtn3V4o85kwguySvPVHde5r3c/fhE3iyCbj+eyj+ce/GVPggAr7n3" +
           "ujfI7buZ8oXnLl143XOjv8qz4EdvW7ex0AU9tu3j6adj9fN+oOlmbozbtsko" +
           "P/95bwQ99HKTi6CLuz+5Sk9vmd8XQXffkBlYMfs5TvtrEXT5NG0Enct/j9P9" +
           "BhhtRwe21LZynOTDEXQWkGTVZ/wT7pHuh4npGvv1WRgFYK23q5CeObmxj9b2" +
           "rpdb22NY8OiJTZw/Ix9uuHj7kHxN+eJz7e67Xqx+apvnV2x5s8mkXGChW7dP" +
           "Dkeb9uGbSjuUdZ55/Cd3fOm2xw7R5Y7thHdb6djcHrxxUp1y/ChPg2/+4HW/" +
           "9+ZPP/edPLP2v+vjh2TfHwAA");
    }
    public class BackAction extends javax.swing.AbstractAction implements org.apache.batik.util.gui.resource.JComponentModifier {
        java.util.List components = new java.util.LinkedList(
          );
        public BackAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (localHistory.
                  canGoBack(
                    )) {
                localHistory.
                  back(
                    );
            }
        }
        public void addJComponent(javax.swing.JComponent c) {
            components.
              add(
                c);
            c.
              setEnabled(
                false);
        }
        protected void update() { boolean b =
                                    localHistory.
                                    canGoBack(
                                      );
                                  java.util.Iterator it =
                                    components.
                                    iterator(
                                      );
                                  while (it.
                                           hasNext(
                                             )) {
                                      ((javax.swing.JComponent)
                                         it.
                                         next(
                                           )).
                                        setEnabled(
                                          b);
                                  } }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "40u/TEPOQvRN/5N1lQ/86f+4bRMqZLnD6XuJfw2/9KuPkz/21xX/WYiX3E/k" +
           "t+MxSNnOeNHf8r579a33feUqdP8auqke54Oi7KZl4KxBDhSfJIkgZ7wwfjGf" +
           "ORzez55C2Jsvw8u5ZS+Dy9k5AJ5L6vL5+iU8qUKtBkLsi8eh9sXLeHIFqh5+" +
           "vGJ5umpvlc0PH1voMNXfgb8r4P9/l/9lf9lxOJAfJY+zgqdO04IQHEzXy2Qh" +
           "8MF5GQO7Pn0Xu87lrEqlnlO/xH3ra58sPvfSIZIVGeQKUO1uWfntLwYlsD/z" +
           "CofTWb723cGPvPxXfyb+xNXj2HvNxc166JU2qyJ9QwI9fD6ODpgzPgBz2aJl" +
           "854DceOuYfAjZUPmVwBCXkOPiCOk/M7e2Qz3lI//EEBpXCX/gMOwfdmt5CcT" +
           "ENaueuvEDCJ4GQBxcMtxiRNxb1bilh53dMigL8lK/l/LCkz58NlkTACS8V/4" +
           "84/+yUfe9k1gtxF0bVf6ODDFuRWnafl+8rMvfewtr3nhW79QnQzgWBDf/8x/" +
           "q7K99StpXDZ82Qgnqj5eqspXWRcjx8mkAnNdq7R9RfiYRbYHzrzdcfINP//o" +
           "Nze/+pefOSTWl7HiErH+oRd+/u+OPvzC1XOvM2+77Y3iPM/hlaYS+rXHO3w+" +
           "CO6wSsXR/4vPPf/7v/H8Bw9SPXoxOafAu+dn/t3/+pOjT3zrq3fIBO91g7+H" +
           "YZOH/3aIx3Tn5I+pr0k0U/O5p7MtncVbwmxEEXSGeJPN3p5hJuVaGmflQh+V" +
           "drqaDgdZndqR62UDK5IGrmDG2ldWs9DbWNQmHNfXc1LvbO2tGU5JmjLrI27T" +
           "Z7mxJekdPhggLknr43AxDjnT7o5ROdnxhqdhSt5Ado4Ybpu6gq53MOzDroHB" +
           "8KzGWsPtNNsv5rO5TO/ZQcyPtaWN9BvxcqMlotJ3FYnEXUxkBzMCs2AJjYKm" +
           "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");
    }
    public class ForwardAction extends javax.swing.AbstractAction implements org.apache.batik.util.gui.resource.JComponentModifier {
        java.util.List components = new java.util.LinkedList(
          );
        public ForwardAction() { super();
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (localHistory.
                  canGoForward(
                    )) {
                localHistory.
                  forward(
                    );
            }
        }
        public void addJComponent(javax.swing.JComponent c) {
            components.
              add(
                c);
            c.
              setEnabled(
                false);
        }
        protected void update() { boolean b =
                                    localHistory.
                                    canGoForward(
                                      );
                                  java.util.Iterator it =
                                    components.
                                    iterator(
                                      );
                                  while (it.
                                           hasNext(
                                             )) {
                                      ((javax.swing.JComponent)
                                         it.
                                         next(
                                           )).
                                        setEnabled(
                                          b);
                                  } }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1ZC2wUxxmeO2NjDH4ChhAw4JggHr2DNDShJjTGscHuGVxM" +
           "LPUgOeZ25+zFe7vL7qx9dkqbIFXQVKWUkKcSVFWk5EFCFDVqaJqIKmoeCqnE" +
           "q2mKQlBTqUnTKEFRaFXapv/M7N4+7nwUtamlm9ub/f9/5n99/z/jwx+hcstE" +
           "TUSjMTpqECvWodFebFpEblexZW2CuZR0fxn+9Pb316+MoookqhnEVo+ELdKp" +
           "EFW2kmiOolkUaxKx1hMiM45ek1jEHMZU0bUkmq5YXVlDVSSF9ugyYQT92Eyg" +
           "ekypqaRtSrocARTNScBO4nwn8bbw69YEmiLpxqhHPtNH3u57wyiz3loWRXWJ" +
           "bXgYx22qqPGEYtHWnImWGLo6OqDqNEZyNLZNXeGYoDuxosAEzc/UXry0d7CO" +
           "m2Aq1jSdcvWsjcTS1WEiJ1CtN9uhkqy1HX0blSXQZB8xRS0Jd9E4LBqHRV1t" +
           "PSrYfTXR7Gy7ztWhrqQKQ2Ibomh+UIiBTZx1xPTyPYOESurozplB23l5bYWW" +
           "BSreuyS+//7b654tQ7VJVKtofWw7EmyCwiJJMCjJpolptckykZOoXgNn9xFT" +
           "waoy5ni6wVIGNExtcL9rFjZpG8Tka3q2Aj+CbqYtUd3Mq5fhAeX8Ks+oeAB0" +
           "bfR0FRp2snlQsEqBjZkZDHHnsEwYUjSZorlhjryOLV8HAmCdmCV0UM8vNUHD" +
           "MIEaRIioWBuI90HoaQNAWq5DAJoUzRpXKLO1gaUhPEBSLCJDdL3iFVBN4oZg" +
           "LBRND5NxSeClWSEv+fzz0fpVe+7Q1mlRFIE9y0RS2f4nA1NTiGkjyRCTQB4I" +
           "ximLE/fhxhd3RxEC4ukhYkHz829duHlp07HXBM3VRWg2pLcRiaakg+maE7Pb" +
           "F60sY9uoNHRLYc4PaM6zrNd505ozAGEa8xLZy5j78tjGV7555xPkwyiq6kIV" +
           "kq7aWYijeknPGopKzLVEIyamRO5Ck4gmt/P3XWgiPCcUjYjZDZmMRWgXmqDy" +
           "qQqd/wYTZUAEM1EVPCtaRnefDUwH+XPOQAhNhg9ahVD5ScT/yk+wkSIpPqhn" +
           "SRxLWFM0Pd5r6kx/Kw6IkwbbDsbTEPVDcUu3TQjBuG4OxDHEwSBxXmDDsOLW" +
           "8EDa1EcADePdff1r+xUyQsxOSFcSY8Fm/H+WyTFtp45EIuCI2WEYUCGD1umq" +
           "TMyUtN9e03Hh6dQbIsRYWjh2omg1rBwTK8f4yjG2csxbORZauaVTN0ewKbdJ" +
           "zNEoEuHLT2P7ETEAHhwCLAAwnrKo77burbubyyD4jJEJYH5G2hwoSu0eYLgo" +
           "n5KONFSPzT+3/OUompBADViiNlZZjWkzBwC9pCEnwaekoVx5VWOer2qwcmfq" +
           "EpEBtMarHo6USn2YmGyeomk+CW5NY9kbH7+iFN0/OvbAyF3931kWRdFgoWBL" +
           "lgPGMfZeBu95GG8JA0QxubW73r945L4dugcVgcrjFswCTqZDczhAwuZJSYvn" +
           "4edSL+5o4WafBFBOMaQeoGRTeI0AErW6qM50qQSFM7qZxSp75dq4ig5CNHkz" +
           "PHLr+fM0CItalpqzIUdPO7nKv9nbRoONM0SkszgLacGrxk19xiO/+80HX+bm" +
           "dgtMra8z6CO01QdqTFgDh696L2w3mYQA3TsP9N5z70e7NvOYBYprii3YwsZ2" +
           "ADNwIZj5u69tf/vdcwdPR704p1DV7TQ0R7m8kpVMp5oSSsJq13r7AVBUCc8x" +
           "q+VWDeJTySg4rRKWWP+oXbD8ub/sqRNxoMKMG0ZLLy/Am79qDbrzjdv/2sTF" +
           "RCRWlD2beWQC6ad6kttME4+yfeTuOjnnwVfxI1AzAKctZYxw6EXcBog7bQXX" +
           "fxkfrw+9u4ENCyx/8Afzy9c8paS9pz+p7v/kpQt8t8Huy+/rHmy0ivBiw7U5" +
           "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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "pGyYlQ3apGt1bVW2CJIWZyV5tnKC+mLO2zg/mXRbyXKzGE9bFWKz1FYbP5C4" +
           "eAJyxzY3HU2UDlNzU7cpy2mjtSAck/KzwCDZeERWkzqabsxt1fYEbi4M5Ply" +
           "kVUqQcD2iEVMCm7fEXqU12ACPBgR4mZEiaO51lt4eJJ5UZvYKshsHm5KKoox" +
           "TqUdlK2JqqyFyFKmk7JAmIMyFo9aibEKNmVyXpLtyXwsdpoZNykN1BZRozoB" +
           "yfHlmJ2EC30659DeBt3GghEG4+G40pc9x4BnfbMzFbNyxk437IIhJknobX27" +
           "U6nadXkhCJ1JqCWbCYwgqNyo1+Ixyg/4YezpQooSzgZLzcGAxqwB8Fg/Vlab" +
           "lch48+XIbWXdaSp5m7prNlK+3xsRWaxQrbBriX6vOV1J1aDStmBMDhbxTK3S" +
           "QV032tq8OYxgT2t3SrLOlbqcX4lcexwRQccSVyJOkm5EpIuZNRG90DascMNQ" +
           "fJNsO5jqYHxpRjfXoxmJ031C4vqmJ3SSfqtEetJ41BaCOt4eeLMt58+HFFNe" +
           "SjODJToTChvgKlU1u3xnVPPEJdXhRnh9lE00zBYmxBrWt9uS7vMajI7Ljs11" +
           "+0RrU+ImFb3mtsujqdlbWRsOm447tX5mOhSB6EZmqFUuI7BasjIWK3LbrLTU" +
           "hLT9EkrOO3SV54RlxacUzpSk1RJ2JAJl5W6jFC1aiTciOWqh1FiJbmzDkVov" +
           "1b1tu0dIzYwSN3ULbcZWj0fr9XrGroBvBY1Vn18FqCQsTEtbuWzP84dbiif6" +
           "G8nhmDq2qi2dGGGrc2FpspgysxaWiIsODXiYOwG+CcaBiqSLqThrE3SZ4Fks" +
           "ljhX0/FZSsJzlhm3jZGxbEkGj9cnyhTZrOB0Nen7LAioCZdRQpcusWo9bKwy" +
           "ZJg2+qtUlvFInhIsjyuzpDodW52kV2MynCTSSSebOzgeMZTQJHCpTChtXGNV" +
           "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" +
           "4fhxUWLd/uFLPvHa33n8G0UF4X8AvXSW5jwmAAA=");
    }
    public class PrintAction extends javax.swing.AbstractAction {
        public PrintAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (svgDocument !=
                  null) {
                final org.w3c.dom.svg.SVGDocument doc =
                  svgDocument;
                new java.lang.Thread(
                  ) {
                    public void run() {
                        java.lang.String uri =
                          doc.
                          getURL(
                            );
                        java.lang.String fragment =
                          svgCanvas.
                          getFragmentIdentifier(
                            );
                        if (fragment !=
                              null) {
                            uri +=
                              '#' +
                              fragment;
                        }
                        org.apache.batik.transcoder.print.PrintTranscoder pt =
                          new org.apache.batik.transcoder.print.PrintTranscoder(
                          );
                        if (application.
                              getXMLParserClassName(
                                ) !=
                              null) {
                            pt.
                              addTranscodingHint(
                                org.apache.batik.transcoder.image.JPEGTranscoder.
                                  KEY_XML_PARSER_CLASSNAME,
                                application.
                                  getXMLParserClassName(
                                    ));
                        }
                        pt.
                          addTranscodingHint(
                            org.apache.batik.transcoder.print.PrintTranscoder.
                              KEY_SHOW_PAGE_DIALOG,
                            java.lang.Boolean.
                              TRUE);
                        pt.
                          addTranscodingHint(
                            org.apache.batik.transcoder.print.PrintTranscoder.
                              KEY_SHOW_PRINTER_DIALOG,
                            java.lang.Boolean.
                              TRUE);
                        pt.
                          transcode(
                            new org.apache.batik.transcoder.TranscoderInput(
                              uri),
                            null);
                        try {
                            pt.
                              print(
                                );
                        }
                        catch (java.awt.print.PrinterException ex) {
                            userAgent.
                              displayError(
                                ex);
                        }
                    }
                }.
                  start(
                    );
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "4fIkEazQV1sjsEN4S7Z1eMer273dnW9Ujw4hwKYte9F8FbuW7atHssvjR82t" +
           "vK9x4XTj+nhza9fxgLKd2AM3O1vId2GffPrZ59Tep5C9g07RBGy8D458dnKy" +
           "rfCTN99udvNzlV374ktP/8tl4a3Gu15FU/ahU5M8LfJ3u89/hXmj8ut70Nmj" +
           "ZsZ1Jz4nma6ebGFc8DWQRY5wopHxwMnGKArM+f0Ds37/xo3RG4bAmTwEto4/" +
           "1YU7c2DAg+7E5bxXICXAirHmhPvbRjmd3efswcs08ZLs4oTQRSln6mt+1v7V" +
           "tgda/LFgEsEGOXZNdRdl7ivtjU/0zELojmNd/MOpF1/tUQAImvuvO33cnpgp" +
           "n33u4vnXPzf667wBfnSqdTsLndcjyzreeTp2f6vna7qZ2+L2bR/Ky39+KYQe" +
           "fqXJhdCF3Z9cpae3zO8LoXtvyAyMmP0cp/2VELp0mjaEzuW/x+l+DYy2owMZ" +
           "tb05TvLhEDoLSLLbZ7wT0ZHuB4npzPcJOQh94OqtF9IzJ/P6yLX3vJJrj0HB" +
           "YydyOD9APsy3aHuEfE353HNt7t0vVT+1bfErlrTZZFLOs9Bt29OGo5x95KbS" +
           "DmXd2nziR3d9/vbHD8Hlru2Ed5l0bG4P3bifTttemHfAN3/4+t9/828/9828" +
           "qfa/BuTQcNkfAAA=");
    }
    public class SaveAsAction extends javax.swing.AbstractAction {
        public SaveAsAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            javax.swing.JFileChooser fileChooser;
            fileChooser =
              new javax.swing.JFileChooser(
                makeAbsolute(
                  currentSavePath));
            fileChooser.
              setDialogTitle(
                resources.
                  getString(
                    "SaveAs.title"));
            fileChooser.
              setFileHidingEnabled(
                false);
            fileChooser.
              setFileSelectionMode(
                javax.swing.JFileChooser.
                  FILES_ONLY);
            fileChooser.
              addChoosableFileFilter(
                new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ImageFileFilter(
                  ".svg"));
            int choice =
              fileChooser.
              showSaveDialog(
                JSVGViewerFrame.this);
            if (choice !=
                  javax.swing.JFileChooser.
                    APPROVE_OPTION)
                return;
            final java.io.File f =
              fileChooser.
              getSelectedFile(
                );
            org.apache.batik.apps.svgbrowser.SVGOptionPanel sop;
            sop =
              org.apache.batik.apps.svgbrowser.SVGOptionPanel.
                showDialog(
                  JSVGViewerFrame.this);
            final boolean useXMLBase =
              sop.
              getUseXMLBase(
                );
            final boolean prettyPrint =
              sop.
              getPrettyPrint(
                );
            sop =
              null;
            final org.w3c.dom.svg.SVGDocument svgDoc =
              svgCanvas.
              getSVGDocument(
                );
            if (svgDoc ==
                  null)
                return;
            statusBar.
              setMessage(
                resources.
                  getString(
                    "Message.saveAs"));
            currentSavePath =
              f;
            java.io.OutputStreamWriter w =
              null;
            try {
                java.io.OutputStream tos =
                  null;
                tos =
                  new java.io.FileOutputStream(
                    f);
                tos =
                  new java.io.BufferedOutputStream(
                    tos);
                w =
                  new java.io.OutputStreamWriter(
                    tos,
                    "utf-8");
            }
            catch (java.lang.Exception ex) {
                userAgent.
                  displayError(
                    ex);
                return;
            }
            final java.io.OutputStreamWriter writer =
              w;
            final java.lang.Runnable doneRun =
              new java.lang.Runnable(
              ) {
                public void run() {
                    java.lang.String doneStr =
                      resources.
                      getString(
                        "Message.done");
                    statusBar.
                      setMessage(
                        doneStr);
                }
            };
            java.lang.Runnable r =
              new java.lang.Runnable(
              ) {
                public void run() {
                    try {
                        writer.
                          write(
                            "<?xml version=\"1.0\" encoding=\"utf-8\"?>");
                        writer.
                          write(
                            EOL);
                        org.w3c.dom.Node fc =
                          svgDoc.
                          getFirstChild(
                            );
                        if (fc.
                              getNodeType(
                                ) !=
                              org.w3c.dom.Node.
                                DOCUMENT_TYPE_NODE) {
                            writer.
                              write(
                                "<!DOCTYPE svg PUBLIC \'");
                            writer.
                              write(
                                org.apache.batik.util.SVGConstants.
                                  SVG_PUBLIC_ID);
                            writer.
                              write(
                                "\' \'");
                            writer.
                              write(
                                org.apache.batik.util.SVGConstants.
                                  SVG_SYSTEM_ID);
                            writer.
                              write(
                                "\'>");
                            writer.
                              write(
                                EOL);
                            writer.
                              write(
                                EOL);
                        }
                        org.w3c.dom.Element root =
                          svgDoc.
                          getRootElement(
                            );
                        boolean doXMLBase =
                          useXMLBase;
                        if (root.
                              hasAttributeNS(
                                org.apache.batik.util.XMLConstants.
                                  XML_NAMESPACE_URI,
                                "base"))
                            doXMLBase =
                              false;
                        if (doXMLBase) {
                            root.
                              setAttributeNS(
                                org.apache.batik.util.XMLConstants.
                                  XML_NAMESPACE_URI,
                                "xml:base",
                                svgDoc.
                                  getURL(
                                    ));
                        }
                        if (prettyPrint) {
                            org.apache.batik.transcoder.svg2svg.SVGTranscoder trans =
                              new org.apache.batik.transcoder.svg2svg.SVGTranscoder(
                              );
                            trans.
                              transcode(
                                new org.apache.batik.transcoder.TranscoderInput(
                                  svgDoc),
                                new org.apache.batik.transcoder.TranscoderOutput(
                                  writer));
                        }
                        else {
                            org.apache.batik.dom.util.DOMUtilities.
                              writeDocument(
                                svgDoc,
                                writer);
                        }
                        writer.
                          close(
                            );
                        if (doXMLBase)
                            root.
                              removeAttributeNS(
                                org.apache.batik.util.XMLConstants.
                                  XML_NAMESPACE_URI,
                                "xml:base");
                        if (java.awt.EventQueue.
                              isDispatchThread(
                                )) {
                            doneRun.
                              run(
                                );
                        }
                        else {
                            java.awt.EventQueue.
                              invokeLater(
                                doneRun);
                        }
                    }
                    catch (java.lang.Exception ex) {
                        userAgent.
                          displayError(
                            ex);
                    }
                }
            };
            org.apache.batik.bridge.UpdateManager um =
              svgCanvas.
              getUpdateManager(
                );
            if (um !=
                  null &&
                  um.
                  isRunning(
                    )) {
                um.
                  getUpdateRunnableQueue(
                    ).
                  invokeLater(
                    r);
            }
            else {
                r.
                  run(
                    );
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "t577dt5Z+1/FeKbv3x8AAA==");
    }
    public class ExportAsJPGAction extends javax.swing.AbstractAction {
        public ExportAsJPGAction() { super(
                                       );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            javax.swing.JFileChooser fileChooser =
              new javax.swing.JFileChooser(
              makeAbsolute(
                currentSavePath));
            fileChooser.
              setDialogTitle(
                resources.
                  getString(
                    "ExportAsJPG.title"));
            fileChooser.
              setFileHidingEnabled(
                false);
            fileChooser.
              setFileSelectionMode(
                javax.swing.JFileChooser.
                  FILES_ONLY);
            fileChooser.
              addChoosableFileFilter(
                new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ImageFileFilter(
                  ".jpg"));
            int choice =
              fileChooser.
              showSaveDialog(
                JSVGViewerFrame.this);
            if (choice ==
                  javax.swing.JFileChooser.
                    APPROVE_OPTION) {
                float quality =
                  org.apache.batik.apps.svgbrowser.JPEGOptionPanel.
                  showDialog(
                    JSVGViewerFrame.this);
                final java.io.File f =
                  fileChooser.
                  getSelectedFile(
                    );
                java.awt.image.BufferedImage buffer =
                  svgCanvas.
                  getOffScreen(
                    );
                if (buffer !=
                      null) {
                    statusBar.
                      setMessage(
                        resources.
                          getString(
                            "Message.exportAsJPG"));
                    int w =
                      buffer.
                      getWidth(
                        );
                    int h =
                      buffer.
                      getHeight(
                        );
                    final org.apache.batik.transcoder.image.ImageTranscoder trans =
                      new org.apache.batik.transcoder.image.JPEGTranscoder(
                      );
                    if (application.
                          getXMLParserClassName(
                            ) !=
                          null) {
                        trans.
                          addTranscodingHint(
                            org.apache.batik.transcoder.image.JPEGTranscoder.
                              KEY_XML_PARSER_CLASSNAME,
                            application.
                              getXMLParserClassName(
                                ));
                    }
                    trans.
                      addTranscodingHint(
                        org.apache.batik.transcoder.image.JPEGTranscoder.
                          KEY_QUALITY,
                        new java.lang.Float(
                          quality));
                    final java.awt.image.BufferedImage img =
                      trans.
                      createImage(
                        w,
                        h);
                    java.awt.Graphics2D g2d =
                      img.
                      createGraphics(
                        );
                    g2d.
                      setColor(
                        java.awt.Color.
                          white);
                    g2d.
                      fillRect(
                        0,
                        0,
                        w,
                        h);
                    g2d.
                      drawImage(
                        buffer,
                        null,
                        0,
                        0);
                    new java.lang.Thread(
                      ) {
                        public void run() {
                            try {
                                currentSavePath =
                                  f;
                                java.io.OutputStream ostream =
                                  new java.io.BufferedOutputStream(
                                  new java.io.FileOutputStream(
                                    f));
                                trans.
                                  writeImage(
                                    img,
                                    new org.apache.batik.transcoder.TranscoderOutput(
                                      ostream));
                                ostream.
                                  close(
                                    );
                            }
                            catch (java.lang.Exception ex) {
                                
                            }
                            statusBar.
                              setMessage(
                                resources.
                                  getString(
                                    "Message.done"));
                        }
                    }.
                      start(
                        );
                }
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "3hQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "4Zs/eMPvveW3rn8rb7H9L1Vxq6ztHwAA");
    }
    public class ExportAsPNGAction extends javax.swing.AbstractAction {
        public ExportAsPNGAction() { super(
                                       );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            javax.swing.JFileChooser fileChooser =
              new javax.swing.JFileChooser(
              makeAbsolute(
                currentSavePath));
            fileChooser.
              setDialogTitle(
                resources.
                  getString(
                    "ExportAsPNG.title"));
            fileChooser.
              setFileHidingEnabled(
                false);
            fileChooser.
              setFileSelectionMode(
                javax.swing.JFileChooser.
                  FILES_ONLY);
            fileChooser.
              addChoosableFileFilter(
                new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ImageFileFilter(
                  ".png"));
            int choice =
              fileChooser.
              showSaveDialog(
                JSVGViewerFrame.this);
            if (choice ==
                  javax.swing.JFileChooser.
                    APPROVE_OPTION) {
                boolean isIndexed =
                  org.apache.batik.apps.svgbrowser.PNGOptionPanel.
                  showDialog(
                    JSVGViewerFrame.this);
                final java.io.File f =
                  fileChooser.
                  getSelectedFile(
                    );
                java.awt.image.BufferedImage buffer =
                  svgCanvas.
                  getOffScreen(
                    );
                if (buffer !=
                      null) {
                    statusBar.
                      setMessage(
                        resources.
                          getString(
                            "Message.exportAsPNG"));
                    int w =
                      buffer.
                      getWidth(
                        );
                    int h =
                      buffer.
                      getHeight(
                        );
                    final org.apache.batik.transcoder.image.ImageTranscoder trans =
                      new org.apache.batik.transcoder.image.PNGTranscoder(
                      );
                    if (application.
                          getXMLParserClassName(
                            ) !=
                          null) {
                        trans.
                          addTranscodingHint(
                            org.apache.batik.transcoder.image.JPEGTranscoder.
                              KEY_XML_PARSER_CLASSNAME,
                            application.
                              getXMLParserClassName(
                                ));
                    }
                    trans.
                      addTranscodingHint(
                        org.apache.batik.transcoder.image.PNGTranscoder.
                          KEY_FORCE_TRANSPARENT_WHITE,
                        java.lang.Boolean.
                          TRUE);
                    if (isIndexed) {
                        trans.
                          addTranscodingHint(
                            org.apache.batik.transcoder.image.PNGTranscoder.
                              KEY_INDEXED,
                            new java.lang.Integer(
                              256));
                    }
                    final java.awt.image.BufferedImage img =
                      trans.
                      createImage(
                        w,
                        h);
                    java.awt.Graphics2D g2d =
                      img.
                      createGraphics(
                        );
                    g2d.
                      drawImage(
                        buffer,
                        null,
                        0,
                        0);
                    new java.lang.Thread(
                      ) {
                        public void run() {
                            try {
                                currentSavePath =
                                  f;
                                java.io.OutputStream ostream =
                                  new java.io.BufferedOutputStream(
                                  new java.io.FileOutputStream(
                                    f));
                                trans.
                                  writeImage(
                                    img,
                                    new org.apache.batik.transcoder.TranscoderOutput(
                                      ostream));
                                ostream.
                                  close(
                                    );
                            }
                            catch (java.lang.Exception ex) {
                                
                            }
                            statusBar.
                              setMessage(
                                resources.
                                  getString(
                                    "Message.done"));
                        }
                    }.
                      start(
                        );
                }
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Yb2wcRxWfu7Md27F9thM7IYkdx3GCnES3CTRA5VBqu7bj" +
           "cLZPcWqBQ3OZ25u723hvdzM7dz67GNpKKKGCEAW3DVXrT64KqG0qRAUIWhlV" +
           "oq0KSC0R0H8pEh8IfyIaIZUPAcqbmb3bvT07UfiAJe/tzr55/9/vvdlnrqFq" +
           "m6JOYrAIm7OIHRkyWAxTmyQHdWzbx2Atrj4Wwv84cXX8ziCqmUZNGWyPqdgm" +
           "wxrRk/Y06tAMm2FDJfY4IUm+I0aJTWgeM800plGbZo9mLV1TNTZmJgknmMI0" +
           "ilowY1RL5BgZdRgw1BEFTRShidLvf90XRQ2qac255Js95IOeN5wy68qyGWqO" +
           "nsJ5rOSYpitRzWZ9BYr2WqY+l9ZNFiEFFjmlH3RccCR6sMIF3c+HP7xxPtMs" +
           "XLABG4bJhHn2UWKbep4koyjsrg7pJGufRl9BoSha7yFmqCdaFKqAUAWEFq11" +
           "qUD7RmLksoOmMIcVOdVYKleIoR3lTCxMcdZhExM6A4da5tguNoO1XSVrpZUV" +
           "Jj6yV1l87ETzD0IoPI3CmjHJ1VFBCQZCpsGhJJsg1O5PJklyGrUYEOxJQjWs" +
           "a/NOpFttLW1gloPwF93CF3MWoUKm6yuII9hGcyozacm8lEgo56k6peM02Nru" +
           "2iotHObrYGC9BorRFIa8c7ZUzWhGkqHt/h0lG3s+DwSwdV2WsIxZElVlYFhA" +
           "rTJFdGyklUlIPSMNpNUmJCBlaMuaTLmvLazO4DSJ84z00cXkK6CqE47gWxhq" +
           "85MJThClLb4oeeJzbfzQufuNw0YQBUDnJFF1rv962NTp23SUpAglUAdyY8Oe" +
           "6KO4/cWzQYSAuM1HLGl+9OXrd+/rXHlV0mxdhWYicYqoLK4uJ5re2DbYe2eI" +
           "q1FrmbbGg19muaiymPOmr2ABwrSXOPKXkeLLlaO/+OID3yd/DaL6UVSjmnou" +
           "C3nUoppZS9MJHSEGoZiR5CiqI0ZyULwfRevgPqoZRK5OpFI2YaOoShdLNaZ4" +
           "BhelgAV3UT3ca0bKLN5bmGXEfcFCCK2Hf9SMUM3bSPzJX4ZUJWNmiYJVbGiG" +
           "qcSoye23FUCcBPg2oyQg62cU28xRSEHFpGkFQx5kiPMCW5at2Pl0gpqzgIbK" +
           "kcmpkSmNzBI6DOVKIjzZrP+PmAK3dsNsIACB2OaHAR0q6LCpJwmNq4u5gaHr" +
           "z8VflynGy8LxE0MDIDkiJUeE5AiXHHElR3ySe4YKlklZvx0bH+lXebBRICBU" +
           "2Mh1knkAUZwBPABAbuidvO/IybPdIUhAa7YKQsBJu8sa06ALGkWkj6uXWhvn" +
           "d1w58HIQVUVRK1ZZDuu8z/TTNCCYOuMUeUMCWpbbObo8nYO3PGqqJAnAtVYH" +
           "cbjUmnlC+TpDGz0cin2NV7CydldZVX+0cnH2wamv7g+iYHmz4CKrAef49hiH" +
           "+BKU9/hBYjW+4TNXP7z06ILpwkVZ9yk2zYqd3IZuf5L43RNX93ThF+IvLvQI" +
           "t9cBnDMM5QdI2emXUYZGfUVk57bUgsEpk2axzl8VfVzPMpBR7orI3hZxvxHS" +
           "IszLswvq9B2nXsUvf9tu8esmme08z3xWiM7x2Unryd//+s+fFO4uNpmwZzqY" +
           "JKzPA2ycWauAsBY3bY9RQoDuvYuxbz9y7cxxkbNAsXM1gT38OgiABiEEN3/t" +
           "1dNvvX9l+XLQzXMGnT2XgAGpUDKyltvUdBMjQdpuVx8ARp2IGrN77jUgP7WU" +
           "hhM64YX1r/CuAy/87VyzzAMdVopptO/WDNz1jw2gB14/8c9OwSag8sbs+swl" +
           "k2i/weXcTyme43oUHnyz4zuv4CehbwBW29o8EfCLhA+QCNpBYf9+cb3D9+7T" +
           "/LLL9iZ/eX15Bqi4ev7yB41TH7x0XWhbPoF5Yz2GrT6ZXvyyuwDsN/nB6TC2" +
           "M0B3x8r4l5r1lRvAcRo4qgDG9gQF1CyUZYZDXb3u7Z+/3H7yjRAKDqN63cTJ" +
           "YSyKDNVBdhM7A4BbsD53t4zubK1sQWAqqjC+YoE7ePvqoRvKWkw4e/7Hm354" +
           "6OmlKyLLLMljq5fhx/llbynfxJt6fxP05lsZB4o61ppTxIy1/NDiUnLiqQNy" +
           "mmgt7/1DMNo++9t//zJy8Q+vrdJoapw50xXIG0FHWSMYE/ObC0bvNV344096" +
           "0gO30wP4WuctUJ4/bwcL9qyN6X5VXnnoL1uO3ZU5eRtwvt3nSz/L740989rI" +
           "bvVCUAyrEskrhtzyTX1er4JQSmAqN7iZfKVR5PzOckj9BET9XSf6764Oqask" +
           "Tgmo1trqK+mAE1H+vBnGapHHeBYcm+cRloPCEL8XMo/dBBG+wC8TUNBYbIrB" +
           "YQB6CUlCtvTe5GRHtSwAe96ZjZWF1vdnnrj6rMxU/yDtIyZnFx/+KHJuUWat" +
           "PG3srBj4vXvkiUOo2yx99hH8BeD/P/yf28IX5MTZOuiMvV2luZfXLkU7bqaW" +
           "EDH8p0sLP/3uwpmg45sRhqrypiaPOJ/hl5is+77/EXP4Qr9VYKilYqwrxnL/" +
           "7U6IYNnmikOpPEipzy2Fazct3fs7UdGlw04D1GYqp+ue1PameY1FSUoTDmiQ" +
           "sG6JnxmY926lHEP17oMw6ZTcDEebtlU3g4v5j5f2NEPNflqGqsWvl46BNJcO" +
           "ME/eeElmGQoBCb8FxPeWSyFiz8LhNNKfgNENcl9GoRCoBHkR+LZbBd6D6jvL" +
           "6kZ8VyhiUk5+WYB5e+nI+P3XP/WUHKBUHc/Pi3MoHKvlLFfCtR1rcivyqjnc" +
           "e6Pp+bpdxbRtkQq7aLPVU+/9gBsWb35bfNOF3VMaMt5aPvTSr87WvAkVehwF" +
           "MEMbjntO9fIICyNKDhrK8ajbUjzfpcTY09f7+Nxd+1J/f0f0T6cFbVubPq5e" +
           "fvq+31zYvAzj0fpRVA0VSQrTqF6z75kzjhI1T6dRo2YPFUBF4KJhfRTV5gzt" +
           "dI6MJqOoiec35l8chF8cdzaWVvn4zVB3JdJUHlpg1oDyGjBzRlIgPfQgd6Xs" +
           "g0exNeQsy7fBXSmFcmOl7XH1nq+Hf3a+NTQMNVpmjpf9OjuXKLUd7zcQtw81" +
           "88uJgsTAUDw6ZllFTAzVWjL3H5Y0fJ2hwB5n1dNQ+OM3BbtviFt++dZ/AQCS" +
           "jN3eFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/+ANv/eW33rum3mL7X8BMrEmzu0fAAA=");
    }
    public class ExportAsTIFFAction extends javax.swing.AbstractAction {
        public ExportAsTIFFAction() { super(
                                        );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            javax.swing.JFileChooser fileChooser =
              new javax.swing.JFileChooser(
              makeAbsolute(
                currentSavePath));
            fileChooser.
              setDialogTitle(
                resources.
                  getString(
                    "ExportAsTIFF.title"));
            fileChooser.
              setFileHidingEnabled(
                false);
            fileChooser.
              setFileSelectionMode(
                javax.swing.JFileChooser.
                  FILES_ONLY);
            fileChooser.
              addChoosableFileFilter(
                new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ImageFileFilter(
                  ".tiff"));
            int choice =
              fileChooser.
              showSaveDialog(
                JSVGViewerFrame.this);
            if (choice ==
                  javax.swing.JFileChooser.
                    APPROVE_OPTION) {
                final java.io.File f =
                  fileChooser.
                  getSelectedFile(
                    );
                java.awt.image.BufferedImage buffer =
                  svgCanvas.
                  getOffScreen(
                    );
                if (buffer !=
                      null) {
                    statusBar.
                      setMessage(
                        resources.
                          getString(
                            "Message.exportAsTIFF"));
                    int w =
                      buffer.
                      getWidth(
                        );
                    int h =
                      buffer.
                      getHeight(
                        );
                    final org.apache.batik.transcoder.image.ImageTranscoder trans =
                      new org.apache.batik.transcoder.image.TIFFTranscoder(
                      );
                    if (application.
                          getXMLParserClassName(
                            ) !=
                          null) {
                        trans.
                          addTranscodingHint(
                            org.apache.batik.transcoder.image.JPEGTranscoder.
                              KEY_XML_PARSER_CLASSNAME,
                            application.
                              getXMLParserClassName(
                                ));
                    }
                    final java.awt.image.BufferedImage img =
                      trans.
                      createImage(
                        w,
                        h);
                    java.awt.Graphics2D g2d =
                      img.
                      createGraphics(
                        );
                    g2d.
                      drawImage(
                        buffer,
                        null,
                        0,
                        0);
                    new java.lang.Thread(
                      ) {
                        public void run() {
                            try {
                                currentSavePath =
                                  f;
                                java.io.OutputStream ostream =
                                  new java.io.BufferedOutputStream(
                                  new java.io.FileOutputStream(
                                    f));
                                trans.
                                  writeImage(
                                    img,
                                    new org.apache.batik.transcoder.TranscoderOutput(
                                      ostream));
                                ostream.
                                  close(
                                    );
                            }
                            catch (java.lang.Exception ex) {
                                
                            }
                            statusBar.
                              setMessage(
                                resources.
                                  getString(
                                    "Message.done"));
                        }
                    }.
                      start(
                        );
                }
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "FAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL05a6wkWVk1d3Z2ZodlZ3Zgl3VlH7M7i+42udWv6qpyEKiu" +
           "rupX9auqu7q7FIZ6d1XXq+vdjauwRkAxsNEFMYH9BVHJ8oiRaGIwa4wCgZhg" +
           "iK9EIMZEFInsD9GIiqeq7719752Z3WxM7Jt7uvqc7/vO967vfOeF70HnAh8q" +
           "eK611i033FfTcN+0kP1w7anBfodBhqIfqAppiUEwBnM35Mc+f+kHP3x2cXkP" +
           "ulOAXic6jhuKoeE6AasGrhWrCgNd2s1SlmoHIXSZMcVYhKPQsGDGCMLrDPSa" +
           "Y6ghdI05ZAEGLMCABThnASZ2UADptaoT2WSGITphsIJ+HjrDQHd6csZeCF09" +
           "ScQTfdE+IDPMJQAULmS/eSBUjpz60KNHsm9lvkngjxTg537jnZd/9yx0SYAu" +
           "GQ6XsSMDJkKwiQDdbau2pPoBoSiqIkD3OqqqcKpviJaxyfkWoCuBoTtiGPnq" +
           "kZKyychT/XzPnebuljPZ/EgOXf9IPM1QLeXw1znNEnUg6/07WbcS0tk8EPCi" +
           "ARjzNVFWD1HuWBqOEkKPnMY4kvFaFwAA1PO2Gi7co63ucEQwAV3Z2s4SHR3m" +
           "Qt9wdAB6zo3ALiH04G2JZrr2RHkp6uqNEHrgNNxwuwSg7soVkaGE0H2nwXJK" +
           "wEoPnrLSMft8r/+WD73baTl7Oc+KKlsZ/xcA0sOnkFhVU33VkdUt4t1PMR8V" +
           "7//iB/YgCADfdwp4C/P7P/fS29/88Itf3sL8+C1gBpKpyuEN+ZPSPV9/I/kk" +
           "fjZj44LnBkZm/BOS5+4/PFi5nnog8u4/opgt7h8uvsj+2fw9n1a/uwddbEN3" +
           "yq4V2cCP7pVd2zMs1W+qjuqLoaq0obtURyHz9TZ0HjwzhqNuZweaFqhhG7rD" +
           "yqfudPPfQEUaIJGp6Dx4NhzNPXz2xHCRP6ceBEGvAf/QZQg6/wiUf7bfISTD" +
           "C9dWYVEWHcNx4aHvZvIHsOqEEtDtApaA1y/hwI184IKw6+uwCPxgoR4siJ4X" +
           "wEGsS76bBKoPdzi+yRtqovo0CFd1P3M27/9nmzST9nJy5gwwxBtPpwELRFDL" +
           "tRTVvyE/F9Wplz5746t7R2FxoKcQIsHO+9ud9/Od97Od93c775/a+RqVeq4f" +
           "EsG4TdOEnFkbOnMm5+H1GVNbRwBmXIKEAFLl3U9y7+i86wOPnQUe6CV3ABtk" +
           "oPDtMza5SyHtPFHKwI+hFz+WvJf/heIetHcy9WaCgKmLGfowS5hHifHa6ZC7" +
           "Fd1L7//ODz730afdXfCdyOUHOeFmzCymHzutct+VVQVkyR35px4Vv3Dji09f" +
           "24PuAIkCJMdQBM4M8s7Dp/c4EdvXD/NkJss5ILDm+rZoZUuHye1iuAD22c3k" +
           "vnBP/nwv0PGlzNmvAq9/9MD78+9s9XVeNr5+6zuZ0U5Jkefhn+a8T/z1n/9T" +
           "JVf3Ycq+dOwlyKnh9WNpIiN2KU8I9+58YOyrKoD7u48Nf/0j33v/z+QOACAe" +
           "v9WG17KRBOkBmBCo+Ze+vPqbb33zk9/Y2zlNCN6TkWQZcnok5IVMpnteRkiw" +
           "25t2/IA0Y6m5wwbXJo7tKoZmiJKlZl76X5eeKH3hXz50eesHFpg5dKM3vzKB" +
           "3fyP1aH3fPWd//5wTuaMnL3mdjrbgW1z5+t2lAnfF9cZH+l7/+Kh3/yS+AmQ" +
           "hUHmC4yNmiczKNcBlBsNzuV/Kh/3T62VsuGR4Ljzn4yvY+XIDfnZb3z/tfz3" +
           "/+ilnNuT9cxxW/dE7/rWvbLh0RSQf8PpSG+JwQLAVV/s/+xl68UfAooCoCiD" +
           "1BYMfJCD0hOecQB97vzf/vGf3P+ur5+F9mjoouWKCi3mQQbdBbxbDRYgfaXe" +
           "296+tW5yYZvQgajQTcJvneKB/NdZwOCTt88vdFaO7EL0gf8cWNIzf/8fNykh" +
           "zyy3eAufwhfgFz7+IPnW7+b4uxDPsB9Ob87LoHTb4ZY/bf/b3mN3/ukedF6A" +
           "LssHdSEvWlEWOAKohYLDYhHUjifWT9Y125f49aMU9sbT6eXYtqeTy+59AJ4z" +
           "6Oz54vF88iPwOQP+/yf7z9SdTWzfplfIg1f6o0fvdM9Lz4BoPVfeR/eLGf7b" +
           "cipX8/FaNvzE1kzZ40+CsA7yghRgaIYjWvnGbw+Bi1nytUPqPChQgU2umRaa" +
           "k7kPlOS5O2XS72+rum1Cy8ZyTmLrEsht3eentlD5m+ueHTHGBQXiB//h2a99" +
           "+PFvAZt2oHNxpm9gymM79qOsZn7fCx956DXPffuDeZYCKYp/zxP/mlcgzMtJ" +
           "nA1UNtCHoj6YicrllQAjBmEvTyyqkkv7sq489A0b5N/4oCCEn77yreXHv/OZ" +
           "bbF32m9PAasfeO5XfrT/oef2jpXYj99U5R7H2ZbZOdOvPdCwD119uV1yDPof" +
           "P/f0H/720+/fcnXlZMFIgfPQZ/7yv7+2/7Fvf+UW1ckdlvt/MGx4d7VVDdrE" +
           "4YcpzbVpIrPpVIvgfkXqwGFKIe1qgFVHk5pRTkai22q7Cp+g0Ywsj1FK0if9" +
           "ja1EUoSHVakibwZlVZuN0rAjsKPR3CDLVXGF84WIXC3C7nJEk7Qr8GI3JJd6" +
           "SPH10WQ9LrRbKdWn2istGblSGfzFWhmlxovGOkWkilbeaGEhhhXbQaPByi53" +
           "I9est+0NKCOEZdqsp+NmmWuGYipN4Pp02cHb7hiWNUYs9Et1vjHo2/5w3rIG" +
           "6XgyL7krLRAVzmuOpcZi6QfypMNplCpTXjyaykmxiCyaqOAqG96uebYXbKiE" +
           "HTuEXEwXq3SesoxgOZ2Bm8y7+qbuue5o0bfWQ7zWa89FXhmICmZX1J7RGk6x" +
           "qiDXeGE8nFBm1BfQJicgqyhtcFKDnbtleyAUnLTZL9kUTZvLsIUSstxiy22q" +
           "S8Mc3hyiOuLygVFp1Fk7mXcWQ7ssq21JXW06QKr5TCmxpIwUkk2N0n26SMyH" +
           "vckQD8TOqD4frdoM6/qTgC6bMttGMKnvThC/Z3ip1UVG+qZkmYO015sgi2JJ" +
           "rhGJXPMWZoTrvVIsTvwOP+U9s1quI1Ztbo8ZBWNcjSiSdtzs0Eqrzk3mZGfZ" +
           "XCAdeWnV0W5nYqymzkRckkkncfigWw0HHToK0GlP55dqYuFFsgT3ptVR1xZr" +
           "cbuN6E2s7G+6IwvD24YrrJ2azw165bq/KEd+2CInfnVQb7Cuy4a9ORagwsSc" +
           "mk3ObkZxEeVMqayl8/a8GYamTwZTtsMLUyB1s7hmZ2wgdNgO1yiaRG3Md4yR" +
           "LkxNP1quEX9dDjYR0eM0sof3WzTCRfpqoQ6qdDAXQUCSk+rIE8uFbssx5EoF" +
           "qw6XLZPrNymCJ5CUZRURheuhOUGUsGh2R50OT7Rke2iioWlGg6ElF5uUzpgK" +
           "u049LW7QTViLUN7DZ0onmFb7dtuxxRW5XvgGJ1VwtzBs1StGN2QFxC6nbl8T" +
           "fNsNfHMj+HWdkDtFq2GuLaRlrHHeHMIxNsIxS0vKxsIwVpNJEXeqPUy0Zn2n" +
           "O/MW9apdXzXnS340KbE9s89tVLZEhZWeXNQxkzdmY7FjrLsrh0v55qArVOps" +
           "01ok9GZGxFNxuVG7+IK3ppW6HCz6RLNAySHZ58ttmHK01OIscS20E28aiJTg" +
           "LbpOx9c0Xq+ny6gh+Z0u5XdwVmr0h+3RhF+W55NGyx515Coj0XZ5HuD2MuRk" +
           "YsNOzGVVHVZSuV0ZUOayiyz1xbAfxXC7JhG+UqzSyYJoMxI6n5At0vSMmmGR" +
           "VMHj4LDRNlmZkzB3Ui3PFoW2vZgLhLwU2ubI6VJctVZdGr3CWiuadTlaSj1D" +
           "NdzaoLFaYmVDH1ENL6gu/Q7bJpKNTugE2a40lklBHo4nkVQdCV2ixCeTtNpl" +
           "cUEoeWVq2m+HI6fUC8PxKMJ5WIWbS5bvKVyTF6TWwMaKo82oQXWlwYCeqXab" +
           "UxFJHLSWsF9tlIe24XWIWTcsFdsy48xspktjjkj3WzpKp4HATGkbBiWtNyyt" +
           "8P5QSzAOjslaR1clTW+vgnptaJYHPa1KeVKlUKINoJJFgMuFaLipupFjsLyD" +
           "dmdS3/Aq8sJEYCs2lWWpXsEL5IwysBjXo0opGai9ZFOqlxoCIihsfak22Knp" +
           "hCFXT6b2GPEbg1nK45UeuV7STGQsTY13mjCptI3NINrQyaqUrq05JseaYplY" +
           "ZNn2AMM2Tjo1lFlaKzp+LURhDMNUOqqGSidKhMZ63mnCI71Z1qYdkwxKk4rU" +
           "nbjtIlNCuxraT2s1bcjRa9pYlH1ymjilQotQKH0xaNg+mhYQr1LxV4hMSh6y" +
           "WZElBOklbZbvsqGQ2ogXzzm2XS7MVgRmuFSJNpUYxusR51ihkEwMFQuGVb7i" +
           "O7AnFRQJoRG31+/25pVyxavVI7jGjgrGol+EC0ExSkjRwHpoUJCx5bLSxIuD" +
           "Ec4akYq03GmrUkCxkh1XxakuE32xHC4JCjaYBbHmSGXZmMdFXEbhLl5YczDK" +
           "cPiax9UZUu10V7QaDTuFItyqzNDlIiSLWiKt01YwnLpUEmuhxRNDUYLVerHe" +
           "DwWXCX1FSxhG81djlag22JQfNfuorncCOnDXSa0Z+XFFGZfgcDDkpyTBtybz" +
           "PlD3yKWX02bNaKKGUKRTsjR3UGvGOmo0jud6r87zTbqQJvWKHM8kl3XaUwpD" +
           "1MKgZaMpjimxvVo3OgwWmragLVjA13htauDc1dLqUgXhA7HuBmipvpikQreI" +
           "BT4n287CjtPEKQcrCU7MXhjAcCHEYLO0qSUpkKPjigIO5NI6zSLtTMmeRBED" +
           "lSxKcZ+G4aoLoz13HHvEbB3WNnN3gxTQZM4otfKgNkNms1bsMKVVVsFqIEvX" +
           "UE1CiwEMSopWP271a9ZMX3dFHlhZnk6mKOIVByFPUW7HHEyafWQQ99u2XClR" +
           "gxVbaKyGcq2o4kqzxMy4TsJNuuVKidc4glMNuLVkNv2JYcKUPGiJU7akD0hj" +
           "iM0CQ470iaG1Ea2zIvVA0ScLvEfg9S6n24kQ9WasabsIMRQEYbOY0mGs2hVn" +
           "VY576wlcHoftwtyhwxreG7YL3FQItW41EPtGNdai5UQeuNMag/ftFlZXCRiG" +
           "E61cZWYIYQp4lPRgrWwRgjbzgwmuIF2Gow2cKszoCoyh8nQzkuXKIrVXtjkp" +
           "qTLwbAamBKU4hN3CPEnVpk+03enYmdHzAYIWEYdt1EMOm6Z8vWaV6uo0qUwl" +
           "qwDDJmd6RafpUED9jqKUxmUExdBN0zW4kBxhRc5aV9Ie1mu01pVJtbaox0rd" +
           "brGi5EqNsRaJNtZqwT2FUavigjaxcITPjFIxbo06HlOvEY6EJks5WdN6e6wR" +
           "EYvWapNRoGq6WncFLmCCerCM3RLR5rtdzGhtUJRjYl2bKMJ8YsZGMhlxyzhe" +
           "V4iEKWHKcFNvIniVXSKjlVud0QHboQl0Knu6T/BxHIXrbtxcDRr9NNB8uiBs" +
           "6Hham5FMmAZYOsYogmyloJjkQ7w619SZ56YVXq8VMDfc9Kd4wxAQgpA3o3Qx" +
           "UGW0iKW9bm/pqgPZYGx8MR5a62WKJ8lg2LDgDY4WQUkAtjPHOirGYwQf+ZsN" +
           "mnSxSLLsemG6aNA03+AEhuw3/RE6jG1z2qcccTZeUfaGTVZ622mwQR2hlZnV" +
           "GCA9p8iPen1tiKXxWtJhkqliNbtorLQ4dVarKieurR4DzDiauVov7lDchMD7" +
           "a7roFQosixIlZA13QplWuq6STsRZSMZqwa8KuCwSUX/klqe22rdm5dhZ1qaF" +
           "KlzsVk3RoJ0qMhUIvUn5VGqsfbINKqBlbMOrAbdYYRu6b4Z+y62RDoxFdqPS" +
           "n7UYBoerzIYVyq6m0+CYkB0f3vHqTnD35ofVo/sIcHDLFlqv4uSyXbqaDU8c" +
           "Nbjy3sbF0z3s4w2uXdcDyk5jD93umiE/iX3ymeeeVwafKu0ddItm4PB9cPuz" +
           "o5Mdh5+6/ZGzl1+x7FoYX3rmnx8cv3XxrlfRmH3kFJOnSf5O74WvNN8k/9oe" +
           "dPaooXHT5c9JpOsn2xgXfTWMfGd8opnx0MnmaBmo8+qBWq/eujl6Sxc4k7vA" +
           "1vCnOnFnDhR40KF4MO8XiAnQYqw64f62WU5lzzl68DKNvCQbnBC6JOZIQ9XP" +
           "WsDq9m6LO+ZMU3BIjl1D2XmZ+0rn4xN9sxC6cnND/1CC4qu9HAC+88BN95Hb" +
           "OzT5s89fuvCG5yd/lffCj+657mKgC1pkWcebUMee7/R8VTNyldy1bUl5+dcv" +
           "htCjr8RcCF3c/chFemaL/L4Quu+WyECX2ddx2F8OocunYUPoXP59HO5XwW47" +
           "OBBY24fjIB8OobMAJHt81jvhJOl+kBiOvk9IQegDi2+tkJ45Gd5HFr7yShY+" +
           "lhEePxHK+ZXyYdhF20vlG/Lnnu/03/1S7VPbbr9siZtNRuUCA53fXjwche7V" +
           "21I7pHVn68kf3vP5u544zDH3bBneBdQx3h65dWudsr0wb4Zv/uANv/eW33r+" +
           "m3l/7X8BpJdI6esfAAA=");
    }
    public class ViewSourceAction extends javax.swing.AbstractAction {
        public ViewSourceAction() { super(
                                      ); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (svgDocument ==
                  null) {
                return;
            }
            final org.apache.batik.util.ParsedURL u =
              new org.apache.batik.util.ParsedURL(
              svgDocument.
                getURL(
                  ));
            final javax.swing.JFrame fr =
              new javax.swing.JFrame(
              u.
                toString(
                  ));
            fr.
              setSize(
                resources.
                  getInteger(
                    "ViewSource.width"),
                resources.
                  getInteger(
                    "ViewSource.height"));
            final org.apache.batik.util.gui.xmleditor.XMLTextEditor ta =
              new org.apache.batik.util.gui.xmleditor.XMLTextEditor(
              );
            ta.
              setFont(
                new java.awt.Font(
                  "monospaced",
                  java.awt.Font.
                    PLAIN,
                  12));
            javax.swing.JScrollPane scroll =
              new javax.swing.JScrollPane(
              );
            scroll.
              getViewport(
                ).
              add(
                ta);
            scroll.
              setVerticalScrollBarPolicy(
                javax.swing.JScrollPane.
                  VERTICAL_SCROLLBAR_ALWAYS);
            fr.
              getContentPane(
                ).
              add(
                scroll,
                java.awt.BorderLayout.
                  CENTER);
            new java.lang.Thread(
              ) {
                public void run() {
                    char[] buffer =
                      new char[4096];
                    try {
                        javax.swing.text.Document doc =
                          new org.apache.batik.util.gui.xmleditor.XMLDocument(
                          );
                        org.apache.batik.util.ParsedURL purl =
                          new org.apache.batik.util.ParsedURL(
                          svgDocument.
                            getURL(
                              ));
                        java.io.InputStream is =
                          u.
                          openStream(
                            getInputHandler(
                              purl).
                              getHandledMimeTypes(
                                ));
                        java.io.Reader in =
                          org.apache.batik.xml.XMLUtilities.
                          createXMLDocumentReader(
                            is);
                        int len;
                        while ((len =
                                  in.
                                    read(
                                      buffer,
                                      0,
                                      buffer.
                                        length)) !=
                                 -1) {
                            doc.
                              insertString(
                                doc.
                                  getLength(
                                    ),
                                new java.lang.String(
                                  buffer,
                                  0,
                                  len),
                                null);
                        }
                        ta.
                          setDocument(
                            doc);
                        ta.
                          setEditable(
                            false);
                        fr.
                          setVisible(
                            true);
                    }
                    catch (java.lang.Exception ex) {
                        userAgent.
                          displayError(
                            ex);
                    }
                }
            }.
              start(
                );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public class FlushAction extends javax.swing.AbstractAction {
        public FlushAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            svgCanvas.
              flush(
                );
            svgCanvas.
              setRenderingTransform(
                svgCanvas.
                  getRenderingTransform(
                    ));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "1NeXoxplFybItBEUJ0NL6BIMs1blNtkL101rMA2Xvq42SKB6jVpLoTiZ1hEj" +
           "VSprsddpij1kzCFJrCozJlSNylCLGlTHHS+0SRxRs8ZkOoUlbmrWOhw/bRTl" +
           "YUytmZDAx0YfC7VxtxVXLJyrs0nI+nqPdQIHrVRnSyJJuF4YeDzdVcY9dMn1" +
           "FSrBuq7TBWdo02pwK5kerOuI1i62OGY00GbksCzgM7G9EqaMWPYEA7gySYLF" +
           "BoCbPEybdaRFU8tFn6zJhT4LgCR0R/WUW7PtjezLaw5dRQxrIUZlviFspUVP" +
           "F2yBW+MFJV3psOPw5e6GqEc0wipTvtWWahWmmJobMpFWLNaIFoRJNBuNGoG2" +
           "FX1Vlm2u0xBd1izYYUtT50W812SmhmfDjVD21EYBDp0ErTECOheD2OvhSM8b" +
           "CQHJVCM1xUciVio2wv6g1yW1Tk1c6bqPdxv+MBx7C7mNFyy1mNaqU7gsxWNl" +
           "1GqZfYJhvY2UyFqBUTjX0DVuRfXlsGJ3aW5Uy1A5ZSqreg3o3xKBzMiF2waH" +
           "lHVtXoSbqdAWWG+CJktqGg4jg17wDaffaMB0QM1IlK/16XYU6jA3RdFJrAor" +
           "Gl2n9SJfriVVZ1IowbS2LsCBMNmUTLhlWmiRmNH1OYZXqVAstuNFNEmDmuD7" +
           "ZaXZQfmEwEmSlilaadMDy1rGLD+OZLhWnYRqt1Hg3H4zkaImEzTThWOPXMrv" +
           "yaW23Sy5NBrLMaGW9GDYx1vjMUnU50J7w7TksaOrAltdltnFpt/YJPCg36fH" +
           "5bkwmfUob1Vvt2GODiK6DuKfdGlrkzZW4jAJEXo8mdd7Nb8woQhPE+oTvWzy" +
           "FXNs1ZB5FfN0jZrCMIrCXEcvW2srZUcVSpo5y9YEC4IuxjBujU0KTNmO0Tqj" +
           "6I3JrF9eVtgZ2VejYgttBBWCZU2E9WdUBNPVQRn2+pQ4rcXDKOnbEwMrtWm6" +
           "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" +
           "C/kIomTZHwAA");
    }
    public class ToggleDebuggerAction extends javax.swing.AbstractAction {
        public ToggleDebuggerAction() { super(
                                          "Toggle Debugger Action");
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (debugger ==
                  null) {
                showDebugger(
                  );
            }
            else {
                hideDebugger(
                  );
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "nxJ01OQUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "xw1GyJHlJvvwKX4Bfv5j9zfe8t2cf7fEM+4HkxuRGSRvO97Sp+1/23v0/J/u" +
           "QRcE6Ip8kBlORCvKFo4AsqHgMF0E2eOJ9yczm+02fu0Iwl5/Gl6ODXsaXHY7" +
           "AnjOqLPnS8fx5EfgcwZ8/yf7ZubOOrb76d2Ng0394aNd3fOSM2C1nivto/vF" +
           "jP+tuZRH8vZq1vzE1k3Z40+CZR3kKSng0ExHtPKB3xaCELPkq4fSJyBFBT65" +
           "urDQXMw9ICnPwynTfn+b120BLWtLuYhtSFRvGT4/taXKd647d8JoF6SIH/iH" +
           "Z772oce+BXzahc7Fmb2BK4+NyERZ1vze5z/8wKue/fYHcpQCEDV59+P/mucg" +
           "9EtpnDVk1rQOVb0/U3WY5wK0GIT9HFhUJdf2JUOZ800b4G98kBLCT939reXH" +
           "vvOZbbp3Om5PEavvf/aXf7T/wWf3jiXZj92Q5x7n2Sba+aRffWBhH3rkpUbJ" +
           "OVr/+Lmn/vC3n3rfdlZ3n0wZSXAi+sxf/vfX9j/67a/cJD+5zXL/D44N73hT" +
           "pxJQ+OGHRuZiaS1PkmkhKoRlqVfXggG3kQlaasyoIToc8Xh30lyp3NyUOXEW" +
           "TCOCR5lqhPbLSqkrlGS7X9aCcB4Z/pwf9nRjIDMB7itjzddXrjT0SII3xPZk" +
           "avq8R9GDFj9u9ZeagavkvMRv3DpeVRJUKCu2gKndtV4P1Jlkp77jaFI1RRcJ" +
           "2pnMpFbkmqxbHqgCNw+GbaXrExZZmvBrdI41pmG3oJEUHGhdscSUDaTDMG2f" +
           "nTvhOFnMhYlr2yWGcVc1X2qxwSaQZWqsmKxBToJ5gJgrw68xrMejQlteifZm" +
           "uJQZY9Ro9KZpazyMbKTVHTXN8YLW2V4YCARZsXxKL5IzWOuMRSawub5aGM+1" +
           "gtiMmyL4I3UD0/JNDyYDy9isRKsrh1MLLi+76IhkpbSktxcCWV8I5WnT1yOW" +
           "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" +
           "g9f93pt+67lv5pW2/wXEWJKD9x8AAA==");
    }
    public class PreviousTransformAction extends javax.swing.AbstractAction implements org.apache.batik.util.gui.resource.JComponentModifier {
        java.util.List components = new java.util.LinkedList(
          );
        public PreviousTransformAction() {
            super(
              );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (transformHistory.
                  canGoBack(
                    )) {
                transformHistory.
                  back(
                    );
                update(
                  );
                nextTransformAction.
                  update(
                    );
                svgCanvas.
                  setRenderingTransform(
                    transformHistory.
                      currentTransform(
                        ));
            }
        }
        public void addJComponent(javax.swing.JComponent c) {
            components.
              add(
                c);
            c.
              setEnabled(
                false);
        }
        protected void update() { boolean b =
                                    transformHistory.
                                    canGoBack(
                                      );
                                  java.util.Iterator it =
                                    components.
                                    iterator(
                                      );
                                  while (it.
                                           hasNext(
                                             )) {
                                      ((javax.swing.JComponent)
                                         it.
                                         next(
                                           )).
                                        setEnabled(
                                          b);
                                  } }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1ZC2wUxxmeO+MHBj8BQwgYcAyIR++SNDShTtIYxwbTM7jY" +
           "sdTjccztztmL93aX3Vn77JQ2QaqgqUopIU8lqKpIyYNgFDVqaBpEFTUPhVTK" +
           "o03TKCRqKpU0RQmKklahbfrPzO7t485HUZtaurm92f//Z/7X9/8zPnoOlVsm" +
           "aiYajdExg1ixTo32YtMicoeKLasf5lLSPWX4421nN6yOoookqh3CVo+ELdKl" +
           "EFW2kmi+olkUaxKxNhAiM45ek1jEHMFU0bUkmqVY3VlDVSSF9ugyYQQD2Eyg" +
           "BkypqaRtSrodARTNT8BO4nwn8fbw67YEmi7pxphHPsdH3uF7wyiz3loWRfWJ" +
           "HXgEx22qqPGEYtG2nIlWGLo6NqjqNEZyNLZDXeWYYH1iVYEJWo7XfXph/1A9" +
           "N8EMrGk65epZm4ilqyNETqA6b7ZTJVlrJ/o2KkugaT5iiloT7qJxWDQOi7ra" +
           "elSw+xqi2dkOnatDXUkVhsQ2RNGioBADmzjriOnlewYJVdTRnTODtgvz2got" +
           "C1S8a0X84D3b6p8oQ3VJVKdofWw7EmyCwiJJMCjJpolptcsykZOoQQNn9xFT" +
           "waoy7ni60VIGNUxtcL9rFjZpG8Tka3q2Aj+CbqYtUd3Mq5fhAeX8Ks+oeBB0" +
           "bfJ0FRp2sXlQsFqBjZkZDHHnsEwZVjSZogVhjryOrV8HAmCtzBI6pOeXmqJh" +
           "mECNIkRUrA3G+yD0tEEgLdchAE2K5k4qlNnawNIwHiQpFpEhul7xCqimckMw" +
           "Fopmhcm4JPDS3JCXfP45t+H6fbdq67QoisCeZSKpbP/TgKk5xLSJZIhJIA8E" +
           "4/Tlibtx0zN7owgB8awQsaD5+bfO37Sy+dQLgubyIjQb0zuIRFPS4XTtK/M6" +
           "lq0uY9uoMnRLYc4PaM6zrNd505YzAGGa8hLZy5j78tSm575526Pkgyiq7kYV" +
           "kq7aWYijBknPGopKzLVEIyamRO5GU4kmd/D33agSnhOKRsTsxkzGIrQbTVH5" +
           "VIXOf4OJMiCCmaganhUto7vPBqZD/DlnIISmwQd1IVT5OOJ/lUfZSJEUH9Kz" +
           "JI4lrCmaHu81daa/FQfESYNth+JpiPrhuKXbJoRgXDcH4xjiYIg4L7BhWHFr" +
           "ZDBt6qOAhvH1fQNrBxQySswuSFcSY8Fm/H+WyTFtZ4xGIuCIeWEYUCGD1umq" +
           "TMyUdNBe03n+WOolEWIsLRw7UbQOVo6JlWN85RhbOeatHAut3ApVYETRbavf" +
           "xJqV0c1su8RcjiIRvpGZbGciGsCXw4AKAMvTl/VtXb99b0sZhKExOgUcwUhb" +
           "AuWpw4MOF+9T0kRjzfiiM1c9G0VTEqgRS9TGKqs27eYg4Jg07KT69DQULq9+" +
           "LPTVD1b4TF0iMsDXZHXEkVKljxCTzVM00yfBrW4sj+OT15ai+0en7h29feA7" +
           "V0ZRNFgy2JLlgHaMvZcBfR7QW8NQUUxu3Z6zn07cvUv3QCNQg9zSWcDJdGgJ" +
           "h0rYPClp+UL8ZOqZXa3c7FMB1CmGJAS8bA6vEcCkNhffmS5VoDALD6yyV66N" +
           "q+kQxJU3w2O4gT/PhLCoY0m6BLJ1wsla/s3eNhlsnC1insVZSAteP27oMx78" +
           "/W/e/zI3t1tq6nw9Qh+hbT54Y8IaOZA1eGHbbxICdG/f23vnXef2bOYxCxRX" +
           "FFuwlY0dAGvgQjDzd1/Y+eY7Zw6/HvXinEJ9t9PQJuXySlYxnWpLKAmrLfH2" +
           "A/CoEp5jVustGsSnklFwWiUssf5Rt/iqJ/+6r17EgQozbhitvLgAb/6yNei2" +
           "l7b9rZmLiUisPHs288gE5s/wJLebJh5j+8jd/ur8+57HD0L1AMS2lHHCQRhx" +
           "GyDutFVc/yv5eE3o3bVsWGz5gz+YX742KiXtf/2jmoGPTp7nuw32YX5f92Cj" +
           "TYQXG5bkQPzsMDitw9YQ0F1zasOWevXUBZCYBIkSQLK10QTszAUiw6Eur/zD" +
           "r55t2v5KGYp2oWpVx3IX5kmGpkJ0E2sIYDdnfO0m4d1R5u56rioqUL5gghl4" +
           "QXHXdWYNyo09/tTsn11/5NAZHmWGkHF5HlXnBVCVd/NeYj/62rW/PfKju0dF" +
           "P7BscjQL8c35bKOa3v3HvxeYnONYkV4lxJ+MH31gbseNH3B+D1AYd2uusHoB" +
           "KHu8Vz+a/STaUvHrKKpMonrJ6Z4HsGqzNE1Cx2i5LTV02IH3we5PtDptecCc" +
           "FwYz37JhKPOqJjwzavZcE0IvntgrIKGPOYl9LIxeEcQfujnLUj4uZ8OX/PGQ" +
           "F1VVQhRF1ayd0jVwtwVun++5nRWsPjtt0U14lDeaKWnL0vqm1tUftwi/Nxeh" +
           "9XWk+57+RTK5tF4SxC3FBAc70YePVElvZZ/7k2C4rAiDoJv1cPwHA2/sOM3h" +
           "uYrV7H7Xkr6KDLXdVxvq8yapZRZohM8jwiTim6It/22rpSlwzFKycDKI9ytZ" +
           "IrNjHtPBaeW+UPkclQIZ6zntsWG1/cPrfnqDMOuiSZLVoz/xjXdfeXB84qgo" +
           "Bsy8FK2Y7GBaeBpmvcHiEv2NFyCfrP3qqfffG9gadeC7lg39InjnUFTrR1lR" +
           "kbbkgS6SB6qZwTgRom/+Xt0v9zeWdUHn0Y2qbE3ZaZNuOZh/lZad9gWOdwDz" +
           "ctKJms/hLwKff7EPixY2IaKmscM5jCzMn0YAS9l7iiLL4VE0Gmy8jg3rhXpt" +
           "xWBdvFrKhhX5cOUJXe0ePNxvf5X347ZjulUF7Tg346CtxKCw8AiLre9w876H" +
           "l3KoUiz/Jzth8tPx4d0HD8kbH7pKhFJj8NTWqdnZx3/3z9Oxe999scgRocK5" +
           "IfC2WxbEGwjaHn7y9jD77doD751oHVxzKX07m2u+SGfOfi8ADZZPHqfhrTy/" +
           "+y9z+28c2n4JLfiCkC3DIh/pOfri2iXSgSi/ZhDFpOB6IsjUFgzhapNQ29SC" +
           "QXtFsA2+GmLmuBM7x4u3wUXCLt9cTsYaasMiwQCcy3MXj4JhR5iHxeGukz3z" +
           "NcdKdHG72EChCcOcqZeYrP8nslWy0+g1ARqpMuIAQHxX4zvDD5x93KlUBWeV" +
           "ADHZe/COz2P7DoqoFfdEVxRc1fh5xF2RwAg2cABeVGoVztH154ldTz+8a4+L" +
           "eODwKSO6Inv4YJfAh/+g7WMT7QafN4JhEAcfnnB8eeLSw2Ay1tJh0MRrU8wa" +
           "haLlAxy+3g9LhMCdbLiDohosyx4bm9ztmer7X4CpWF+AFoCeJx19T5YwVbjv" +
           "gkPaVMPUKZR1Iod6sIYSMksY4scl3v2EDfcBsNqGDHUnZJ37/xfWyVE0e5KL" +
           "GtfFV17qzQ8kypyCy2ZxQSodO1RXNfvQLW9wvM9fYk4H5M7YqurvnX3PFYZJ" +
           "Mgo3yXTRSYuqe5SihRfbHLS/3g+u0mOCeYKiWUWZIWPZl5/2CYrqw7QUlfNv" +
           "P92TsJpHB44TD36SpygqAxL2eMIIgKmbRe3QBpuAjMILuYivnjp+5O6fdTH3" +
           "51n8VxIMVfn/C9yKZfc6TeHEofUbbj3/lYfElYik4vFxJmUatFHidiZf9RZN" +
           "Ks2VVbFu2YXa41MXuyjYIDbsZdblvihvh7wy2HF2bui+wGrNXxu8efj6ky/v" +
           "rXgV8HszimCKZmwuPK/lDBvajc2JwnYROgR+kdG27P6xG1dmPnyLn4hRwTk4" +
           "TJ+SXj+y9bUDcw43R9G0blQOAE9y/CB585i2iUgjZhLVKFZnDrYIUhSsBnrR" +
           "WhbfmP0ngdvFMWdNfpZdqFHUUliHCq8hq1Ud0muNbmsy7wOgQ/FmAv/IcBsH" +
           "2zBCDN6M79iUEsWNeQMiM5XoMQy3941+ZnCU2B4Gfz7JuU/zRza8/G+pECwr" +
           "SxwAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "dXNFlfRRP2iko/UkTOIJqUyEKunAVGG6ZslILKftTkx0tGlL4Ih2sxQ7S7a3" +
           "5tR+QyuibmE68OzWtBMy4wTn5NGA9yq0Pe1XsbEpDzQpoupxhNZ94E7sWJZW" +
           "ekov+aJSCuPqWJlbnfHKb4tyW7HaITFLyvVuvbdibZiPZnKtJhdD0ey20oHB" +
           "KQlnyvV46ifl3oAs1NjiYjzf6JbVKym1dpFnW0tjPKmx7e4yRHBNMMq0UcS7" +
           "bKXWHHHMslZghizfLMlllixavbA5E6lZa8F37XlKsBu+Vyyu9UYwLYfzwoAt" +
           "YZJVKGoubiI1XavjfFEc90ljjdCMbVBSbyUqDX2Mj6bV/ojj0hgVKxu3iCsr" +
           "boWOiP7IqG0mU6VJq22DNouBMCRsv8AxVXGwFGcSquBkr1EinDZdn1TlemXV" +
           "UohF39R1Z4LxXrPONCvrNV8BsFRYjFKaQxNkUDZYeGgyhCcUnUqDoUtJaEtw" +
           "iGp90w5domS5IS9O6pE2RHCvl+JVeApr8KaDRqVoWXGT2sgsmDKLlYVqRxqI" +
           "9ZLWpmQ57RBqG9YRdOXONB2RB0JKpOMZScaJLRTVentljObNjVqChYIm4GJS" +
           "ganVzHJbdC2qDUd0PFtPbCF1pz7TrTsBo1NIHdzaWj425+MwaocTd2GTydTi" +
           "QnAqjCPYWtJwoRKU8JYx8jayaUUrxqjLcGXd1yzExuVaIDqMxVnhkAqRatVo" +
           "YSGc0Iwm0yY2L1TnKhwH1QKGU80iU6r3JohNUcRobKbtdTOOSF6B1ytMa6Ee" +
           "KvPhtL3BjE1BmOFlpGvNIh1G5o7XHrI+7sYJOLNmmF5DiDkrjGZtTF6Mhpuw" +
           "17SipCaMimRpI4WDqbaacQ2REBqdxWTEdEvFERtu6pyVVFpxAG+aAYZFyArr" +
           "tgUf8aY+n6KdGbZw2v6CLraQsCM0VVcfFJ2yWhpjMVYJLG/JMZhhmHZ5NKNm" +
           "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");
    }
    public class NextTransformAction extends javax.swing.AbstractAction implements org.apache.batik.util.gui.resource.JComponentModifier {
        java.util.List components = new java.util.LinkedList(
          );
        public NextTransformAction() { super(
                                         );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (transformHistory.
                  canGoForward(
                    )) {
                transformHistory.
                  forward(
                    );
                update(
                  );
                previousTransformAction.
                  update(
                    );
                svgCanvas.
                  setRenderingTransform(
                    transformHistory.
                      currentTransform(
                        ));
            }
        }
        public void addJComponent(javax.swing.JComponent c) {
            components.
              add(
                c);
            c.
              setEnabled(
                false);
        }
        protected void update() { boolean b =
                                    transformHistory.
                                    canGoForward(
                                      );
                                  java.util.Iterator it =
                                    components.
                                    iterator(
                                      );
                                  while (it.
                                           hasNext(
                                             )) {
                                      ((javax.swing.JComponent)
                                         it.
                                         next(
                                           )).
                                        setEnabled(
                                          b);
                                  } }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public class UseStylesheetAction extends javax.swing.AbstractAction implements org.apache.batik.util.gui.resource.JComponentModifier {
        java.util.List components = new java.util.LinkedList(
          );
        public UseStylesheetAction() { super(
                                         );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            
        }
        public void addJComponent(javax.swing.JComponent c) {
            components.
              add(
                c);
            c.
              setEnabled(
                false);
        }
        protected void update() { alternateStyleSheet =
                                    null;
                                  java.util.Iterator it =
                                    components.
                                    iterator(
                                      );
                                  org.w3c.dom.svg.SVGDocument doc =
                                    svgCanvas.
                                    getSVGDocument(
                                      );
                                  while (it.
                                           hasNext(
                                             )) {
                                      javax.swing.JComponent stylesheetMenu =
                                        (javax.swing.JComponent)
                                          it.
                                          next(
                                            );
                                      stylesheetMenu.
                                        removeAll(
                                          );
                                      stylesheetMenu.
                                        setEnabled(
                                          false);
                                      javax.swing.ButtonGroup buttonGroup =
                                        new javax.swing.ButtonGroup(
                                        );
                                      for (org.w3c.dom.Node n =
                                             doc.
                                             getFirstChild(
                                               );
                                           n !=
                                             null &&
                                             n.
                                             getNodeType(
                                               ) !=
                                             org.w3c.dom.Node.
                                               ELEMENT_NODE;
                                           n =
                                             n.
                                               getNextSibling(
                                                 )) {
                                          if (n instanceof org.apache.batik.dom.StyleSheetProcessingInstruction) {
                                              org.apache.batik.dom.StyleSheetProcessingInstruction sspi;
                                              sspi =
                                                (org.apache.batik.dom.StyleSheetProcessingInstruction)
                                                  n;
                                              org.apache.batik.dom.util.HashTable attrs =
                                                sspi.
                                                getPseudoAttributes(
                                                  );
                                              final java.lang.String title =
                                                (java.lang.String)
                                                  attrs.
                                                  get(
                                                    "title");
                                              java.lang.String alt =
                                                (java.lang.String)
                                                  attrs.
                                                  get(
                                                    "alternate");
                                              if (title !=
                                                    null &&
                                                    "yes".
                                                    equals(
                                                      alt)) {
                                                  javax.swing.JRadioButtonMenuItem button;
                                                  button =
                                                    new javax.swing.JRadioButtonMenuItem(
                                                      title);
                                                  button.
                                                    addActionListener(
                                                      new java.awt.event.ActionListener(
                                                        ) {
                                                          public void actionPerformed(java.awt.event.ActionEvent e) {
                                                              org.apache.batik.dom.svg.SVGOMDocument doc;
                                                              doc =
                                                                (org.apache.batik.dom.svg.SVGOMDocument)
                                                                  svgCanvas.
                                                                  getSVGDocument(
                                                                    );
                                                              doc.
                                                                clearViewCSS(
                                                                  );
                                                              alternateStyleSheet =
                                                                title;
                                                              svgCanvas.
                                                                setSVGDocument(
                                                                  doc);
                                                          }
                                                      });
                                                  buttonGroup.
                                                    add(
                                                      button);
                                                  stylesheetMenu.
                                                    add(
                                                      button);
                                                  stylesheetMenu.
                                                    setEnabled(
                                                      true);
                                              }
                                          }
                                      }
                                  } }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "HAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public class PlayAction extends javax.swing.AbstractAction implements org.apache.batik.util.gui.resource.JComponentModifier {
        java.util.List components = new java.util.LinkedList(
          );
        public PlayAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            svgCanvas.
              resumeProcessing(
                );
        }
        public void addJComponent(javax.swing.JComponent c) {
            components.
              add(
                c);
            c.
              setEnabled(
                false);
        }
        public void update(boolean enabled) {
            java.util.Iterator it =
              components.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                ((javax.swing.JComponent)
                   it.
                   next(
                     )).
                  setEnabled(
                    enabled);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "ZM3pfwOz+jrvhxwAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL16e8zk1nUfd/VarWXtSrZlR7VlyV4lkSb4OCTnGcWJh0PO" +
           "cIbkDIfkcB6JLfNNzvAxwzfpKHEcJHZrwDZa2XUBW38UDtIESmTk0TZoXago" +
           "2iSwEcCBkUeB2kZSoElTI/EfeSBuk1xyvvfuyhXS5gO+O5zLc+49555zfvfc" +
           "e+blb0L3hQFU2/lObjp+dKRn0dHGaR5F+U4Pj8ZMk5ODUNf6jhyGIuh7Xn3X" +
           "F278xbc/ad28Ct2/ht4ke54fyZHteyGvh76T6BoD3TjrJR3dDSPoJrORExmO" +
           "I9uBGTuMnmOgN5xjjaBbzIkIMBABBiLAlQhw74wKML1R92K3X3LIXhTuoR+D" +
           "rjDQ/Tu1FC+Cnro4yE4OZPd4GK7SAIxwrfwuAaUq5iyAnjzV/aDzbQp/qga/" +
           "+M/ff/OX7oFurKEbtieU4qhAiAhMsoYecnVX0YOwp2m6toYe8XRdE/TAlh27" +
           "qOReQ4+GtunJURzop4tUdsY7PajmPFu5h9RStyBWIz84Vc+wdUc7+Xaf4cgm" +
           "0PWxM10PGg7KfqDgdRsIFhiyqp+w3Lu1PS2C3nmZ41THWzQgAKwPuHpk+adT" +
           "3evJoAN69GA7R/ZMWIgC2zMB6X1+DGaJoMfvOmi51jtZ3cqm/nwEve0yHXd4" +
           "BagerBaiZImgt1wmq0YCVnr8kpXO2eebkx/4+Ac9yrtayazpqlPKfw0wPXGJ" +
           "idcNPdA9VT8wPvQs82n5sS9+9CoEAeK3XCI+0PybH/3We7/viVd/40Dzj+5A" +
           "M1U2uho9r35eefgrb+8/072nFOPazg/t0vgXNK/cnzt+81y2A5H32OmI5cuj" +
           "k5ev8v9l9aGf1//kKnR9BN2v+k7sAj96RPXdne3owVD39ECOdG0EPah7Wr96" +
           "P4IeAM+M7emH3qlhhHo0gu51qq77/eo7WCIDDFEu0QPg2fYM/+R5J0dW9Zzt" +
           "IAh6A/iHuhB07Xuh6u/a95RtBKmw5bs6LKuyZ3s+zAV+qX8I616kgLW1YAV4" +
           "/RYO/TgALgj7gQnLwA8s/fiFvNuFcJiYSuCnoR7AY0EaSrae6sEAhKt+VDrb" +
           "7h9mmqzU9mZ65QowxNsvw4ADIojyHU0PnldfjHHyW7/4/JeunobF8TpF0HNg" +
           "5qPDzEfVzEflzEdnMx9dmvkWGDnvqaWVoStXqrnfXApzcABgvi0AAgCRDz0j" +
           "vG/8gY++6x7gebv0XrD2JSl8d6Tun0HHqAJIFfgv9Opn0p+Qfrx+Fbp6EXJL" +
           "BUDX9ZKdK4HyFBBvXQ61O4174yN/9BevfPoF/yzoLmD4MRbczlnG8rsuL3Xg" +
           "q7oG0PFs+GeflH/1+S++cOsqdC8ACACKkQycGODNE5fnuBDTz53gY6nLfUBh" +
           "ww9c2SlfnYDa9cgCdjnrqXzg4er5EbDGN0on/y7g7c8ee331Wb59065s33zw" +
           "mdJol7So8Pc9wu5zv/dbf4xVy30C1TfObX6CHj13Dh7KwW5UQPDImQ+Iga4D" +
           "uv/2Ge6ffeqbH/nhygEAxbvvNOGtsu0DWAAmBMv8U7+x//2vf+3zX7165jQR" +
           "2B9jxbHV7FTJa6VOD7+GkmC27z6TB8CLo1cOG96ae66v2YYtK45eeun/vvE0" +
           "8qv/6+M3D37ggJ4TN/q+7zzAWf934dCHvvT+v3yiGuaKWm5vZ2t2RnbAzDed" +
           "jdwLAjkv5ch+4rff8S9+Xf4cQF+AeKFd6BWIQdUaQJXR4Er/Z6v26NI7pGze" +
           "GZ53/ovxdS4NeV795Ff/7I3Sn/2Hb1XSXsxjztualXfPHdyrbJ7MwPBvvRzp" +
           "lBxagK7x6uRHbjqvfhuMuAYjqgDSwmkAsCe74BnH1Pc98F//43967ANfuQe6" +
           "OoCuO76sDeQqyKAHgXfroQVgK9v90HsP1k1Lc9+sVIVuU/7gFG+rvt0LBHzm" +
           "7vgyKNOQsxB9219PHeXDf/BXty1ChSx32H0v8a/hlz/7eP8H/6TiPwvxkvuJ" +
           "7HY8BinbGS/68+6fX33X/f/5KvTAGrqpHueDkuzEZeCsQQ4UniSJIGe88P5i" +
           "PnPYvJ87hbC3X4aXc9NeBpezfQA8l9Tl8/VLeFKFWg18PnMcas9cxpMrUPXw" +
           "QxXLU1V7q2y+59hCh6H+FvxdAf9/U/6X/WXHYUN+tH+cFTx5mhbswMZ0vUwW" +
           "fA/slyGw61N3sSsvp1Uq9bz6a7NvfOVzxSsvHyJZkUGuANXulpXffjAogf3p" +
           "19iczvK1Px9+/6t//IfS+64ex94bLi7WQ6+1WBXpWyLo4fNxdMAc+gDMZYuW" +
           "zXsPxM27hsH3l00/uwIQ8j70qH1UL79P72yGe8rH7wVQGlbJP+AwbE92Kvn7" +
           "EQhrR711YgYJHAZAHNzaOO0TcW9W4pYed3TIoC/J2v+/lhWY8uGzwRgfJOMf" +
           "+++f/PIn3v11YLcxdF9S+jgwxbkZJ3F5Pvnplz/1jje8+I2PVTsD2BakDz39" +
           "p1W2t34tjctGKBvxRNXHS1WFKuti5DBiKzDXtUrb14QPLrBdsOclx8k3/MKj" +
           "X99+9o9+4ZBYX8aKS8T6R1/8J3979PEXr547zrz7thPFeZ7DkaYS+o3HK3w+" +
           "CO4wS8Ux+B+vvPDv/tULHzlI9ejF5JwEZ89f+J3/8+Wjz3zjN++QCd7r+H8P" +
           "w0Y33kw1wlHv5I9B1sYSnyP8Ao5z0sK5MW6O8A4+svChy2Dmar4n5JE1tvot" +
           "U8DwguJxJ4iSdi5zCYUlNa3ZzQV5sfdmrTkRO1IyKBymO3PoUaosEGaw0qfz" +
           "ojtEc4eWW9gmQ3hvHyymrN+W6QUWxYZei2rdjVafrhF37bbbrW67m3Nqp53A" +
           "bKs5qRsG31ws7PV+zLuTetHHF8Eg3vQXmTyeTJ1VmMh9r76ryQ0angynGjgL" +
           "b/b0fkz7SurIxqaPCX7WQ1b5ku9tFwU9WW9Xbt0es5PhmMxscsmS8/pyuXXt" +
           "xSpZusRgwQ+0vbdOTXHI4i5FYpQz3tHoXt4iTbfnm1KGjjxSy8eI5XSxbELW" +
           "F6Ix5DiyySVkjGWh6xrcIrStvT2F+yPEzvfymFbVhU0tt2LEx63pRvZbG37Y" +
           "2QiogGCOO8Q3Bpi3L+2nCNbN25Fs4W6rP5Q2osYGUthezQREo4S+PG0FmK7s" +
           "lttgmvATZDAA8iF9iZsPPXXpLHC+z6+RyFhsV5yO8MykWIq7pdX2C4nf5miG" +
           "D+zGVBxONuR0ocv4pFMUA3xCaVhzNcHR+Xyg+IsFD7bHupAaMRpRqZ/u5l5d" +
           "ROxI4SKbI8a2GW5Ngdg6uewO1t54y+aCyGs91MBIhMP3GybWmYCfmytEHCJp" +
           "goYLxN0q2ZQP9GDV5xrjeGcjIibkvlNb9FSvKa2deafP+Kiu+DSxjFZcbq38" +
           "DjEs+ukQIxxibNaDhS/blk7yOI8oSer3WYrPN1HPShRiPu4hBI76c3IwzCb2" +
           "BunBQn3G9yOkN+yNt1KR19u0MkRMnTe5rcUTa9KMR1ILR3A+7hMyCdI+ixUb" +
           "oj50QAiENbidg/MgVhu2Z5OFxQ9WbGc92oMzITKx5tTEr+OyMBZkfIr3iF2O" +
           "MljDVcS4xYxMsR/Wmf4sXntYYbW78nKyazYkNpnQ+TCbtvNRLqouVfcWXhPT" +
           "kUBummjLRDUysgqz6xd7NmwoxS7Hkx5LooOh5jEul+TIWPYSrC2SxlgfTJZ1" +
           "396tpVpdbQztVjBVWV5YAngY8SQyFVpzSbTHyq4Rd9v1Bd/Y2KFMKqgSIi5T" +
           "HzTqgi5pkhjAhKDQqSWyPLFMg6G1xpZ1lMUxu8C2xEicSZxrIrNIMmZcnui2" +
           "E9Br2hmJCDXuZ8ApB3V6Qe1Fqsv0wvXYRFFqRwim4di5NgnJPrlvTQXLSlly" +
           "pkpNM233tjI6SxV9v0lHipAlLbw7Y+mhILlEYxbY4jAdGjVjbYxZNHM325nZ" +
           "WHmtFe4II7+Htlx74AqbphnUwloN3ez1GZkNLHnqCZu9OZY2q3i+WhbeUPKb" +
           "Tbqj9em20S8AFLAJm9tbsYFuuPXanPVSCiNmPbGXTTi5toeVmJoYQjo3i8zW" +
           "cGbt+TaKbyaiE64kpiN4zcWQi2pTZikVqcSvOXuPUwzCrvZC0deaNj5ziiLk" +
           "Ob0+mc72DDoPO/s568QRuxRW6xWd5Xt1ut5JvjESlGCH2q6SrjBfoWaOuve2" +
           "TabNt4yYCpBmg1WcOT+brE0XXffnMwqP9dUk0xscsWCJeO4GWq1dxAbFREVU" +
           "a2d8n4jiiZvLfVH0hQW7CfDmPKFz3rAzhPW0QCvCeYOg6JXc6DV2IbHv8D5N" +
           "Tp0uvWaihakOVpgK0CtAUgXp9ixzzCxTlGx7Iszhg808bNudfm9cd/mpD4/j" +
           "riKOV1Mk6XlTMtz1JG4oGegQNuCGaCSG7ypopw6IWrk/hmeEVduE6laeLrVJ" +
           "F+23EWFGNget9hSj2pQOJ5i6yvrZaOkg+9RRJC0diuZsQxRRs9aFd3NsuenW" +
           "x3FgeeSYjrqT2VCfM4KzKjzdd+f4eBF3RIUo+rbg2exCxpayD3YsOTEjcrda" +
           "cejGCF06g1utpE6Zs9FcH9Tlped1+gFcszXddpuY1kHD3LNVMxxhIdrpzMhC" +
           "hdN13KiLYjHs7oZwTZ0PukVOtBs62RP4iNanZCdv25Mtocpy3IDDqBkXTL3t" +
           "MQuGoTqNHjx0WmAbDF3MS9xUiwli3IFzbLZmmHYtqbUJfqQTA3eb5CyHhSzh" +
           "ROlkNcvpeidaOG0TC/YUm68s3HFWw0EQpk7dnXXMtDmMPa6glkVbirhJHV8F" +
           "qI/vpKy51YsRy4qzQZ1Ew5FLrJMltUA604avYiohZXOJluB5Oss7ISMGsccO" +
           "m+pKh2Ev9Fpp0+BwZLMZEwUxTFI6KHqtgu5jZhKOah2N8xIigc3CGfC9QJDW" +
           "bW4WEw6MtXK3Cxc7pT53m0W28DfpeDPv0nytpqDtJcqJbX2UzdB4Ixke0+85" +
           "DJo5GTY2+CzaGztpAMDJN5U1vTapcLgvWBLpbxd2UxJnc2RFYelqzEmEquEq" +
           "rVL5qsDaY4tOWGEspoVsrNUhOkqoaBN1JpiLU2sFoJltE3C9Yw8YXYnZiQTX" +
           "Gy0ylYw5OUcG8zT3/eVsgi1qBIqv28pCZfZRl11gqzGlL9D1NlATZWHtlwbC" +
           "2zDeVlNnvcyGLRgeGOPxhBmiMwsbjPcNl8hqGmHJiSdhk0lip+TS4U2zOVx1" +
           "xxSSNKaSxmB4K3BXTb0VgRXrDq2oiPO0PsHX3JydhfU01qwVz2SiRqFwW27V" +
           "rVljIWyb0142WjTnaq70RUoDe6fWqCHwtkmncxvxOJloGFJh1mKdw+mVpgzW" +
           "K0baFnAWiRqHFd1am7ZGeJh3BsxiOW2EC6qBrxUF35pJMOx1NlQLJFKtCMXw" +
           "fYsB6YKWNfdRL8gKGtg8bBUjYRIyPK7uyMmSHZFtEplonR3cGi9ADqvvibxF" +
           "LqVov1aVJqeLBFEbOxGKmqra7hROJguEG8Imk9KG0Sa5WZoEJG3t2hQzBfkl" +
           "jWeEOU9k3Q/NXMeFAe7GyYpFhr7UpGjJXwZNOd8F9Z6UgU1Wb65TGEPX2BZW" +
           "ithdINLcXLIFEe1oAh8xPGKFq6aqdLF6x5lPQZ42MNogLSA6AtW10oY78Tpp" +
           "D0SGqpgzGVFCbMrBXMtgOmJsJNMmudf7dKwJ6SSK+TXYXBm+CzNEpBrrQFP0" +
           "riaPEXWCDpApGgbwtuOIXjvhe/UFSF53tWHEMZzHYFMssDAZ7D1OjaVnjDoR" +
           "uSjDuoyHOB0b4w1vYm5NlxdVsKWQ2my2WbojUd5ZK7KtLnE2MfOUzNtmE0Pr" +
           "rpT2NVMCB8p8Vp84i/5slDLbjpaQ/pCSSV0y1XYQrFmkWyij0V7ZaAGN85bb" +
           "69IkCBM45zeiZO3GZG7y+z077c3M9qLZWcF2DRg5Y50lvxDmpsittHi6KFCu" +
           "QfSCpS3HG9uPwjWcWRknzBrmZqGauMZFPd+oG5y3aoeGgW6w5c7I0ulQ5L2Z" +
           "04CHBDcjYbinOVQt8SeUDZMrAceJ1pwadOlB2iLULetZW1Is6vVMzgTB8btp" +
           "jQoML+31ozbnDvzdXhWUDbGYanqRiYZhFKw1DxJp1artWx11MJWGSDAEoMX4" +
           "Gd5n6knogPx1HDVRU+EGPR5rxxGFwX2UHu81ZClIq34Ok0bcZjtdkhoXRNds" +
           "5U28tpEnG3pWzEdoAmvwymA7gzGmb1Y1xtHnS90NSWcHomdARoxjOHwKL6RO" +
           "p6ZPMYajyDmz7XuzWTBC98Ge6Yy7BbIYCsqIjjqj+nxNM10KVf3t0kOz3G9y" +
           "mElbddHEumxdzgUzp+roWjO6e3U+WfHgsBNsMazVJNt9eZzqNdLs1raC6u/N" +
           "Ht/1NkKf6efDRkszQbZFD9aNEQ9n44VCaVqxCTttr6OOZnC3PvRRo5akqyWC" +
           "Kf290OIoLW+0VnKxxJo9jMZGtNUw1u0Jay137JJj5/XYsMNg2lQRKZKJaKlh" +
           "BU1u1P3ODyd6TraK1AhF38TNJso0G6uY2heLNMEIumEsOM4LDGmezGxmZdn0" +
           "yrc8xQZy6+p0GLuSkjCb2BrQBNaw6tGk3o4SRWj39KSzZxF6s5tZNUns7DwC" +
           "aSN1tJkRhUTWI16TZvuVqS8bdrJYs2idAZ4yHcvWIpimXcUabOdBT6ZBWjdU" +
           "OkWt36Gixs4uoohglHgFsn5nKrNLzBUXeyIeImKgI0S/4/sTMdNNBsYpMiAn" +
           "YTozp4ATbtK5NLK9LbEdu3Q3c4eLOk9xxbzB6mlYgIiDBQRes9jOSKdFbRMk" +
           "VpaCQ/B73lMej7ev74bikeoy5rS2uXHa5QvpdZzMD6+eKpunTy+nqtu46yd1" +
           "sJPP85fmZzepV04ufpq3VYeqmwQzto8C/VC7Ohr3Ty7qji9TgvKu4h13K3hW" +
           "9xSf//CLL2nTn0FO7tCMCLr/uA59JsU9YJhn734hw1bF3rNL1V//8P98XPxB" +
           "6wOvo1T0zktCXh7y59iXf3P43eo/vQrdc3rFelsZ+iLTcxcvVq8HehQHnnjh" +
           "evUdF8s1KDBG7dgotTuXa+7oQFcqBzq4zaXawJWLZny8uk2TU7CKCbDT0aF8" +
           "R5bPFftPvkZp4SNl82MRdEOumDg9KItS+qHKLp9zRT2C7k18Wzvz0R//TrdH" +
           "5+eqOj54cWVgsCLw8crA/19W5rGqjnoUprZnnvPkivXF11iVz5TNJyLojbKm" +
           "nbGVnf/4TP9P/n31Ly/eG8f6N/7f63/Jeg8ovu/oslfx/cvXUP5ny+ZzIGTj" +
           "nSZH+iWtX3o9WmcRdP2soHxilfrrLUoDpHjbbb+DOfx2Q/3Fl25ce+tL89+t" +
           "arGnv694kIGuGbHjnC+CnHu+fxfo4NhbUR5KIrvq4wsR9OR3Eg6odPalUumV" +
           "A/MvR9Bb7sgMIqf8OE/7ryPo5mXaCLqv+jxP92tgtjM6YJPDw3mSfx9B9wCS" +
           "8vGLuwuQcOL4PSWMAhDfBytkV86B8LFjVpZ99DtZ9pTlfLW3BO7qp0wnIBtz" +
           "xyWbV14aTz74rdbPHKrNqiMXRTnKNQZ64FD4PgXqp+462slY91PPfPvhLzz4" +
           "9MmO8vBB4LMgOSfbO+9c2iXdXVQVY4t/+9Zf+YGffelrVa3h7wDWemC2YyYA" +
           "AA==");
    }
    public class PauseAction extends javax.swing.AbstractAction implements org.apache.batik.util.gui.resource.JComponentModifier {
        java.util.List components = new java.util.LinkedList(
          );
        public PauseAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            svgCanvas.
              suspendProcessing(
                );
        }
        public void addJComponent(javax.swing.JComponent c) {
            components.
              add(
                c);
            c.
              setEnabled(
                false);
        }
        public void update(boolean enabled) {
            java.util.Iterator it =
              components.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                ((javax.swing.JComponent)
                   it.
                   next(
                     )).
                  setEnabled(
                    enabled);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "LX9kzel/A3USbXSJHAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "i8pqbP5Lr/35t3/yub8oiw3/DQkNrNdlJgAA");
    }
    public class StopAction extends javax.swing.AbstractAction implements org.apache.batik.util.gui.resource.JComponentModifier {
        java.util.List components = new java.util.LinkedList(
          );
        public StopAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            svgCanvas.
              stopProcessing(
                );
        }
        public void addJComponent(javax.swing.JComponent c) {
            components.
              add(
                c);
            c.
              setEnabled(
                false);
        }
        public void update(boolean enabled) {
            java.util.Iterator it =
              components.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                ((javax.swing.JComponent)
                   it.
                   next(
                     )).
                  setEnabled(
                    enabled);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "kTWn/wMypeY8hxwAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public class SetTransformAction extends javax.swing.AbstractAction {
        public SetTransformAction() { super(
                                        );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (transformDialog ==
                  null) {
                transformDialog =
                  org.apache.batik.ext.swing.JAffineTransformChooser.
                    createDialog(
                      JSVGViewerFrame.this,
                      resources.
                        getString(
                          "SetTransform.title"));
            }
            java.awt.geom.AffineTransform txf =
              transformDialog.
              showDialog(
                );
            if (txf !=
                  null) {
                java.awt.geom.AffineTransform at =
                  svgCanvas.
                  getRenderingTransform(
                    );
                if (at ==
                      null) {
                    at =
                      new java.awt.geom.AffineTransform(
                        );
                }
                txf.
                  concatenate(
                    at);
                svgCanvas.
                  setRenderingTransform(
                    txf);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "uh5p6x8AAA==");
    }
    public class MonitorAction extends javax.swing.AbstractAction {
        public MonitorAction() { super();
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (memoryMonitorFrame ==
                  null) {
                memoryMonitorFrame =
                  new org.apache.batik.util.gui.MemoryMonitor(
                    );
                java.awt.Rectangle fr =
                  getBounds(
                    );
                java.awt.Dimension md =
                  memoryMonitorFrame.
                  getSize(
                    );
                memoryMonitorFrame.
                  setLocation(
                    fr.
                      x +
                      (fr.
                         width -
                         md.
                           width) /
                      2,
                    fr.
                      y +
                      (fr.
                         height -
                         md.
                           height) /
                      2);
            }
            memoryMonitorFrame.
              setVisible(
                true);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Yb2wcRxWfu7Md27F9thM7IYmdxHGCnES3CTRA5RDquHbi" +
           "cLZPcWqBQ3OZ252723hvd7M7a59dDG0llDQtIQpuG6rWn1wVUNtUiAoQtDKq" +
           "RFsVkFoioKCmSHwg/IlohFQ+BChvZnZv9/bsROEDJ93+mXnz3rx/v/dmn7+O" +
           "qm0LdRKdJuiMSezEgE5T2LKJ0q9h2z4GY2n5yRj+x4lrI3dHUc0Easpje1jG" +
           "NhlUiabYE6hD1W2KdZnYI4QobEXKIjaxpjBVDX0Ctan2UMHUVFmlw4ZCGME4" +
           "tpKoBVNqqRmHkiGXAUUdSdiJxHci9YWne5OoQTbMGZ98fYC8PzDDKAu+LJui" +
           "5uQpPIUlh6qalFRt2lu00C7T0GZymkETpEgTp7R9rgmOJPdVmKDrpfiHNy/k" +
           "m7kJ1mBdNyhXzz5KbEObIkoSxf3RAY0U7NPoKyiWRKsDxBR1Jz2hEgiVQKin" +
           "rU8Fu28kulPoN7g61ONUY8psQxRtLWdiYgsXXDYpvmfgUEtd3fli0HZLSVuh" +
           "ZYWKj++S5p880fy9GIpPoLiqj7HtyLAJCkImwKCkkCGW3acoRJlALTo4e4xY" +
           "KtbUWdfTrbaa0zF1wP2eWdigYxKLy/RtBX4E3SxHpoZVUi/LA8p9q85qOAe6" +
           "tvu6Cg0H2TgoWK/Cxqwshrhzl1RNqrpC0ebwipKO3Z8HAli6qkBo3iiJqtIx" +
           "DKBWESIa1nPSGISengPSagMC0KJow4pMma1NLE/iHEmziAzRpcQUUNVxQ7Al" +
           "FLWFyTgn8NKGkJcC/rk+sv/8A/phPYoisGeFyBrb/2pY1BladJRkiUUgD8TC" +
           "hp3JJ3D7K2ejCAFxW4hY0Pzgyzfu2d259Iag2bgMzWjmFJFpWl7MNL29qb/n" +
           "7hjbRq1p2CpzfpnmPMtS7kxv0QSEaS9xZJMJb3Lp6M+++OB3yV+jqH4I1ciG" +
           "5hQgjlpko2CqGrEOEZ1YmBJlCNURXenn80NoFTwnVZ2I0dFs1iZ0CFVpfKjG" +
           "4O9goiywYCaqh2dVzxres4lpnj8XTYTQavijZoRqH0H8J+4UyVLeKBAJy1hX" +
           "dUNKWQbT35YAcTJg27yUgaiflGzDsSAEJcPKSRjiIE/cCWyatmRP5TKWMQ1o" +
           "KB0ZGz80rpJpYg1CupIECzbz/yOmyLRdMx2JgCM2hWFAgww6bGgKsdLyvHNw" +
           "4MaL6bdEiLG0cO1E0QGQnBCSE1xygklO+JITIcndw4auQnr3yczRKBLh4tey" +
           "/YgYAA9OAhYAGDf0jN1/5OTZrhgEnzldBeZnpF1lRanfBwwP5dPy5dbG2a1X" +
           "974WRVVJ1Ipl6mCN1Zg+KwfoJU+6Cd6QgXLlV40tgarByp1lyEQB0Fqperhc" +
           "ao0pYrFxitYGOHg1jWWvtHJFWXb/aOnS9EPjX90TRdHyQsFEVgPGseUpBu8l" +
           "GO8OA8RyfONnrn14+Yk5w4eKssrjFcyKlUyHrnCAhM2TlnduwS+nX5nr5mav" +
           "AyinGFIPULIzLKMMiXo9VGe61ILCWcMqYI1NeTaup3mIJn+ER24Lf14LYRFn" +
           "qbkJcvScm6v8zmbbTXZdJyKdxVlIC141PjtmPvPbX/75k9zcXoGJBzqDMUJ7" +
           "A6DGmLVy+Grxw/aYRQjQvXcp9c3Hr585zmMWKLYtJ7CbXfsBzMCFYOavvXH6" +
           "3fevLl6J+nFOoao7GWiOiiUla5lOTbdQEqTt8PcDoKgRnmN29306xKeaVXFG" +
           "Iyyx/hXfvvflv51vFnGgwYgXRrtvz8Af/9hB9OBbJ/7ZydlEZFaUfZv5ZALp" +
           "1/ic+ywLz7B9FB96p+Nbr+NnoGYATtvqLOHQi7gNEHfaPq7/Hn69KzT3aXbZ" +
           "bgeDvzy/As1TWr5w5YPG8Q9evcF3W959BX09jM1eEV7ssqMI7NeFwekwtvNA" +
           "d9fSyJeataWbwHECOMoAxPaoBYhZLIsMl7p61e9++lr7ybdjKDqI6jUDK4OY" +
           "Jxmqg+gmdh7Atmh+7h7h3elaUX5AVVShfMUAM/Dm5V03UDApN/bsD9d9f/9z" +
           "C1d5lJmCx8Ygw4+zy65SvPGZ+nABDMZbGQcLdazUo/D+avHh+QVl9Nm9opNo" +
           "La/7A9DWvvDrf/88cekPby5TZGrcHtMXyApBR1khGOa9mw9G7zVd/OOPunMH" +
           "76QGsLHO26A8e98MGuxcGdPDW3n94b9sOHYgf/IO4HxzyJZhlt8Zfv7NQzvk" +
           "i1HeqAokr2hwyxf1Bq0KQi0CHbnO1GQjjTzmt5VD6ifA64+63n90eUhdJnBK" +
           "QLXS0lBKR1yPsvf10FLzOMbTYNgp5mHRKAywZy7z2C0Q4QvsMgoJjfmiFBwE" +
           "oJYQBaKl5xanOkstALBPuX2xNNf6/uTT114QkRpuokPE5Oz8uY8S5+dF1IqT" +
           "xraKZj+4Rpw2+Habhc0+gl8E/v9hf6YLGxDdZmu/2/JuKfW8LHcttPVW2+Ii" +
           "Bv90ee7H3547E3Vtc4iiqilDFcebz7BLSuR97/+IOWygzyxS1FjW0nl+3HOn" +
           "nSFotb7iMCoOUPKLC/HadQv3/YZnc+mQ0wB5mXU0LRDWwRCvMS2SVbnyDQLS" +
           "TX6bhF7vdpujqN5/4SqdEovhSNO27GIwL7sFaU9T1Bympaia34N0FKT5dIB3" +
           "4iFIMk1RDEjYI6B9MFWKCXsaDqWJvgy0bRD3wgvFSCXAc6e33c7pAUTfVpYz" +
           "/HuCh0eO+KIAvfbCkZEHbnzqWdE8yRqeneXnTzhOiz6uhGlbV+Tm8ao53HOz" +
           "6aW67V7ItogN+0izMZDrfYAZJit8G0Kdhd1dajDeXdz/6i/O1rwD2XkcRTBF" +
           "a44HTvPi6ArtiQPF5HjSLyeB71G85enteWrmwO7s33/Pa6dbfjatTJ+Wrzx3" +
           "/68url+E1mj1EKqGbCTFCVSv2vfO6EeJPGVNoEbVHijCFoGLirUhVOvo6mmH" +
           "DClJ1MTiG7MvDdwurjkbS6Os9aaoqxJlKg8s0GdAeh00HF3hKA/1xx8p+9Dh" +
           "lQXHNEML/JGSK9dW6p6W730k/pMLrbFByNEydYLsV9lOplRygt8+/BrUzC4n" +
           "igL/YunksGl6eBhrNEXsnxM0bJyiyE53NFBM2OvXObvH+CO7fOO/jHvextYU" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/hd9O+Tq4R8AAA==");
    }
    public class FindDialogAction extends javax.swing.AbstractAction {
        public FindDialogAction() { super(
                                      ); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (findDialog ==
                  null) {
                findDialog =
                  new org.apache.batik.apps.svgbrowser.FindDialog(
                    JSVGViewerFrame.this,
                    svgCanvas);
                findDialog.
                  setGraphicsNode(
                    svgCanvas.
                      getGraphicsNode(
                        ));
                findDialog.
                  pack(
                    );
                java.awt.Rectangle fr =
                  getBounds(
                    );
                java.awt.Dimension td =
                  findDialog.
                  getSize(
                    );
                findDialog.
                  setLocation(
                    fr.
                      x +
                      (fr.
                         width -
                         td.
                           width) /
                      2,
                    fr.
                      y +
                      (fr.
                         height -
                         td.
                           height) /
                      2);
            }
            findDialog.
              setVisible(
                true);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "FAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "t/3W89/Iu2v/CwP6xMbnHwAA");
    }
    public class ThumbnailDialogAction extends javax.swing.AbstractAction {
        public ThumbnailDialogAction() { super(
                                           );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (thumbnailDialog ==
                  null) {
                thumbnailDialog =
                  new org.apache.batik.apps.svgbrowser.ThumbnailDialog(
                    JSVGViewerFrame.this,
                    svgCanvas);
                thumbnailDialog.
                  pack(
                    );
                java.awt.Rectangle fr =
                  getBounds(
                    );
                java.awt.Dimension td =
                  thumbnailDialog.
                  getSize(
                    );
                thumbnailDialog.
                  setLocation(
                    fr.
                      x +
                      (fr.
                         width -
                         td.
                           width) /
                      2,
                    fr.
                      y +
                      (fr.
                         height -
                         td.
                           height) /
                      2);
            }
            thumbnailDialog.
              setInteractionEnabled(
                !svgCanvas.
                  getDisableInteractions(
                    ));
            thumbnailDialog.
              setVisible(
                true);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "srjw5hQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Nh0/74unf/Cm33vbbz33rbzV9r+4ewZd+R8AAA==");
    }
    public class FullScreenAction extends javax.swing.AbstractAction {
        public FullScreenAction() { super(
                                      ); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (window ==
                  null ||
                  !window.
                  isVisible(
                    )) {
                if (window ==
                      null) {
                    window =
                      new javax.swing.JWindow(
                        JSVGViewerFrame.this);
                    java.awt.Dimension size =
                      java.awt.Toolkit.
                      getDefaultToolkit(
                        ).
                      getScreenSize(
                        );
                    window.
                      setSize(
                        size);
                }
                svgCanvas.
                  getParent(
                    ).
                  remove(
                    svgCanvas);
                window.
                  getContentPane(
                    ).
                  add(
                    svgCanvas);
                window.
                  setVisible(
                    true);
                window.
                  toFront(
                    );
                svgCanvas.
                  requestFocus(
                    );
            }
            else {
                svgCanvas.
                  getParent(
                    ).
                  remove(
                    svgCanvas);
                svgCanvasPanel.
                  add(
                    svgCanvas,
                    java.awt.BorderLayout.
                      CENTER);
                window.
                  setVisible(
                    false);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "FAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "q+iu/S8QNui05x8AAA==");
    }
    public class DOMViewerAction extends javax.swing.AbstractAction {
        public DOMViewerAction() { super(
                                     ); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            openDOMViewer(
              );
        }
        public void openDOMViewer() { if (domViewer ==
                                            null ||
                                            domViewer.
                                            isDisplayable(
                                              )) {
                                          domViewer =
                                            new org.apache.batik.apps.svgbrowser.DOMViewer(
                                              svgCanvas.new JSVGViewerDOMViewerController(
                                                ));
                                          java.awt.Rectangle fr =
                                            getBounds(
                                              );
                                          java.awt.Dimension td =
                                            domViewer.
                                            getSize(
                                              );
                                          domViewer.
                                            setLocation(
                                              fr.
                                                x +
                                                (fr.
                                                   width -
                                                   td.
                                                     width) /
                                                2,
                                              fr.
                                                y +
                                                (fr.
                                                   height -
                                                   td.
                                                     height) /
                                                2);
                                      }
                                      domViewer.
                                        setVisible(
                                          true);
        }
        public org.apache.batik.apps.svgbrowser.DOMViewer getDOMViewer() {
            return domViewer;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "PiQNHxcAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "pbjiB/GaS+ZG6lj1pamVLTGxCi2lQiPi1OdLU3YTa4W2jomJJnJsgXeHCVIq" +
           "IK5vb0yUiqqs1C77SM0i2yV7OFywCcj4TIL2Viu6zQV6XeUUdtnnPASVmchx" +
           "+Tob6CKrBDqqt+p6zLCsxQ06iQIOKa9/fXZ8edNLO0HekR+WDx5DwMEx6+i8" +
           "hJPTtuuhrHj04IItv1s5f/IC/egF2+GtC5SdBu+73htHfhL86DueeVZlPlbc" +
           "2butEsDhf+/p6fjtzePXP/LS+fvO4RXKF97xL/eO3mC+5SVcDD9wYpInRX6c" +
           "fu5L5GuU9+9Apw8uVK56eTrOdPn4Ncp5Xwsj3xkdu0y57/jlLArM+a09s37r" +
           "2pez1wyBU3kIbB1/4ibw1N71+t4Nyb35fYUUAyuuNSfc3V7Wt7N6zh7c4CIx" +
           "zgonhC5IOROr+dkVtLZ9WOOPBNMUHNLXrqUeRpn7Yufzo2PlDYvjlnkEWOTb" +
           "e5b59k/HMkdVe+cN+t6VFW8LodtcT3MOXjmyxs2hgk/9BAq+Kmt8FCj2gz0F" +
           "f/DTV/DpG/S9PyveG0K3Glp4oN9+wDz+og9Bx1lya/zaS7FGAiLqxOPR/uDI" +
           "S32FAjhxz1UP39vHWuVTz14498pnx3+Tv7scPKjeQkHn9Mi2j154Hqmf9XxN" +
           "t3Iz3bK9/vTyr4+E0IMvNrkQOn/4I1fpw1vm3w6hu67JDNZN9nWU9ndC6OJJ" +
           "2hA6k38fpftdMNohHQDRbeUoycdD6DQgyaqf8I4BQrIbxJZj7DbkIPTB6t56" +
           "ITl1HMoP3Hvni7n3CPo/cgy28/9d2IfYaPvfC1eUTz/bG7z1herHti9Lii2l" +
           "aSblHAXdvH3kOoDph64rbV/W2c5jP7r9M7c8ur+f3L6d8OEKOjK3B679jNNe" +
           "emH+8JL+0Ss/+7rfe/br+V3u/wFRqaloVCIAAA==");
    }
    protected java.util.Map listeners = new java.util.HashMap(
      );
    public javax.swing.Action getAction(java.lang.String key)
          throws org.apache.batik.util.gui.resource.MissingListenerException {
        javax.swing.Action result =
          (javax.swing.Action)
            listeners.
            get(
              key);
        if (result ==
              null) {
            throw new org.apache.batik.util.gui.resource.MissingListenerException(
              "Can\'t find action.",
              RESOURCES,
              key);
        }
        return result;
    }
    long time;
    public void documentLoadingStarted(org.apache.batik.swing.svg.SVGDocumentLoaderEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.documentLoad");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
            time =
              java.lang.System.
                currentTimeMillis(
                  );
        }
        statusBar.
          setMainMessage(
            msg);
        stopAction.
          update(
            true);
        svgCanvas.
          setCursor(
            WAIT_CURSOR);
    }
    public void documentLoadingCompleted(org.apache.batik.swing.svg.SVGDocumentLoaderEvent e) {
        if (debug) {
            java.lang.System.
              out.
              print(
                resources.
                  getString(
                    "Message.documentLoadTime"));
            java.lang.System.
              out.
              println(
                (java.lang.System.
                   currentTimeMillis(
                     ) -
                   time) +
                " ms");
        }
        setSVGDocument(
          e.
            getSVGDocument(
              ),
          e.
            getSVGDocument(
              ).
            getURL(
              ),
          e.
            getSVGDocument(
              ).
            getTitle(
              ));
    }
    public void setSVGDocument(org.w3c.dom.svg.SVGDocument svgDocument,
                               java.lang.String svgDocumentURL,
                               java.lang.String svgDocumentTitle) {
        this.
          svgDocument =
          svgDocument;
        if (domViewer !=
              null) {
            if (domViewer.
                  isVisible(
                    ) &&
                  svgDocument !=
                  null) {
                domViewer.
                  setDocument(
                    svgDocument,
                    (org.w3c.dom.css.ViewCSS)
                      svgDocument.
                      getDocumentElement(
                        ));
            }
            else {
                domViewer.
                  dispose(
                    );
                domViewer =
                  null;
            }
        }
        stopAction.
          update(
            false);
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
        java.lang.String s =
          svgDocumentURL;
        locationBar.
          setText(
            s);
        if (debugger !=
              null) {
            debugger.
              detach(
                );
            debugger.
              setDocumentURL(
                s);
        }
        if (title ==
              null) {
            title =
              getTitle(
                );
        }
        java.lang.String dt =
          svgDocumentTitle;
        if (dt.
              length(
                ) !=
              0) {
            setTitle(
              title +
              ": " +
              dt);
        }
        else {
            int i =
              s.
              lastIndexOf(
                "/");
            if (i ==
                  -1)
                i =
                  s.
                    lastIndexOf(
                      "\\");
            if (i ==
                  -1) {
                setTitle(
                  title +
                  ": " +
                  s);
            }
            else {
                setTitle(
                  title +
                  ": " +
                  s.
                    substring(
                      i +
                        1));
            }
        }
        localHistory.
          update(
            s);
        application.
          addVisitedURI(
            s);
        backAction.
          update(
            );
        forwardAction.
          update(
            );
        transformHistory =
          new org.apache.batik.apps.svgbrowser.TransformHistory(
            );
        previousTransformAction.
          update(
            );
        nextTransformAction.
          update(
            );
        useStylesheetAction.
          update(
            );
    }
    public void documentLoadingCancelled(org.apache.batik.swing.svg.SVGDocumentLoaderEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.documentCancelled");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
        }
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            msg);
        stopAction.
          update(
            false);
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
    }
    public void documentLoadingFailed(org.apache.batik.swing.svg.SVGDocumentLoaderEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.documentFailed");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
        }
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            msg);
        stopAction.
          update(
            false);
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
    }
    public void gvtBuildStarted(org.apache.batik.swing.svg.GVTTreeBuilderEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.treeBuild");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
            time =
              java.lang.System.
                currentTimeMillis(
                  );
        }
        statusBar.
          setMainMessage(
            msg);
        stopAction.
          update(
            true);
        svgCanvas.
          setCursor(
            WAIT_CURSOR);
    }
    public void gvtBuildCompleted(org.apache.batik.swing.svg.GVTTreeBuilderEvent e) {
        if (debug) {
            java.lang.System.
              out.
              print(
                resources.
                  getString(
                    "Message.treeBuildTime"));
            java.lang.System.
              out.
              println(
                (java.lang.System.
                   currentTimeMillis(
                     ) -
                   time) +
                " ms");
        }
        if (findDialog !=
              null) {
            if (findDialog.
                  isVisible(
                    )) {
                findDialog.
                  setGraphicsNode(
                    svgCanvas.
                      getGraphicsNode(
                        ));
            }
            else {
                findDialog.
                  dispose(
                    );
                findDialog =
                  null;
            }
        }
        stopAction.
          update(
            false);
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
        svgCanvas.
          setSelectionOverlayXORMode(
            application.
              isSelectionOverlayXORMode(
                ));
        svgCanvas.
          requestFocus(
            );
        if (debugger !=
              null) {
            debugger.
              attach(
                );
        }
    }
    public void gvtBuildCancelled(org.apache.batik.swing.svg.GVTTreeBuilderEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.treeCancelled");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
        }
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            msg);
        stopAction.
          update(
            false);
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
        svgCanvas.
          setSelectionOverlayXORMode(
            application.
              isSelectionOverlayXORMode(
                ));
    }
    public void gvtBuildFailed(org.apache.batik.swing.svg.GVTTreeBuilderEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.treeFailed");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
        }
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            msg);
        stopAction.
          update(
            false);
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
        svgCanvas.
          setSelectionOverlayXORMode(
            application.
              isSelectionOverlayXORMode(
                ));
        if (autoAdjust) {
            pack(
              );
        }
    }
    public void svgLoadEventDispatchStarted(org.apache.batik.swing.svg.SVGLoadEventDispatcherEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.onload");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
            time =
              java.lang.System.
                currentTimeMillis(
                  );
        }
        stopAction.
          update(
            true);
        statusBar.
          setMainMessage(
            msg);
    }
    public void svgLoadEventDispatchCompleted(org.apache.batik.swing.svg.SVGLoadEventDispatcherEvent e) {
        if (debug) {
            java.lang.System.
              out.
              print(
                resources.
                  getString(
                    "Message.onloadTime"));
            java.lang.System.
              out.
              println(
                (java.lang.System.
                   currentTimeMillis(
                     ) -
                   time) +
                " ms");
        }
        stopAction.
          update(
            false);
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            resources.
              getString(
                "Message.done"));
    }
    public void svgLoadEventDispatchCancelled(org.apache.batik.swing.svg.SVGLoadEventDispatcherEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.onloadCancelled");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
        }
        stopAction.
          update(
            false);
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            msg);
    }
    public void svgLoadEventDispatchFailed(org.apache.batik.swing.svg.SVGLoadEventDispatcherEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.onloadFailed");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
        }
        stopAction.
          update(
            false);
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            msg);
    }
    public void gvtRenderingPrepare(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
        if (debug) {
            java.lang.String msg =
              resources.
              getString(
                "Message.treeRenderingPrep");
            java.lang.System.
              out.
              println(
                msg);
            time =
              java.lang.System.
                currentTimeMillis(
                  );
        }
        stopAction.
          update(
            true);
        svgCanvas.
          setCursor(
            WAIT_CURSOR);
        statusBar.
          setMainMessage(
            resources.
              getString(
                "Message.treeRendering"));
    }
    public void gvtRenderingStarted(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
        if (debug) {
            java.lang.String msg =
              resources.
              getString(
                "Message.treeRenderingPrepTime");
            java.lang.System.
              out.
              print(
                msg);
            java.lang.System.
              out.
              println(
                (java.lang.System.
                   currentTimeMillis(
                     ) -
                   time) +
                " ms");
            time =
              java.lang.System.
                currentTimeMillis(
                  );
            msg =
              resources.
                getString(
                  "Message.treeRenderingStart");
            java.lang.System.
              out.
              println(
                msg);
        }
    }
    public void gvtRenderingCompleted(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
        if (debug) {
            java.lang.String msg =
              resources.
              getString(
                "Message.treeRenderingTime");
            java.lang.System.
              out.
              print(
                msg);
            java.lang.System.
              out.
              println(
                (java.lang.System.
                   currentTimeMillis(
                     ) -
                   time) +
                " ms");
        }
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            resources.
              getString(
                "Message.done"));
        if (!svgCanvas.
              isDynamic(
                ) ||
              managerStopped) {
            stopAction.
              update(
                false);
        }
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
        transformHistory.
          update(
            svgCanvas.
              getRenderingTransform(
                ));
        previousTransformAction.
          update(
            );
        nextTransformAction.
          update(
            );
    }
    public void gvtRenderingCancelled(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.treeRenderingCancelled");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
        }
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            msg);
        if (!svgCanvas.
              isDynamic(
                )) {
            stopAction.
              update(
                false);
        }
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
    }
    public void gvtRenderingFailed(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.treeRenderingFailed");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
        }
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            msg);
        if (!svgCanvas.
              isDynamic(
                )) {
            stopAction.
              update(
                false);
        }
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
    }
    public void linkActivated(org.apache.batik.swing.svg.LinkActivationEvent e) {
        java.lang.String s =
          e.
          getReferencedURI(
            );
        if (svgDocument !=
              null) {
            org.apache.batik.util.ParsedURL docURL =
              new org.apache.batik.util.ParsedURL(
              svgDocument.
                getURL(
                  ));
            org.apache.batik.util.ParsedURL url =
              new org.apache.batik.util.ParsedURL(
              docURL,
              s);
            if (!url.
                  sameFile(
                    docURL)) {
                return;
            }
            if (s.
                  indexOf(
                    '#') !=
                  -1) {
                localHistory.
                  update(
                    s);
                locationBar.
                  setText(
                    s);
                if (debugger !=
                      null) {
                    debugger.
                      detach(
                        );
                    debugger.
                      setDocumentURL(
                        s);
                }
                application.
                  addVisitedURI(
                    s);
                backAction.
                  update(
                    );
                forwardAction.
                  update(
                    );
                transformHistory =
                  new org.apache.batik.apps.svgbrowser.TransformHistory(
                    );
                previousTransformAction.
                  update(
                    );
                nextTransformAction.
                  update(
                    );
            }
        }
    }
    public void managerStarted(org.apache.batik.bridge.UpdateManagerEvent e) {
        if (debug) {
            java.lang.String msg =
              resources.
              getString(
                "Message.updateManagerStarted");
            java.lang.System.
              out.
              println(
                msg);
        }
        managerStopped =
          false;
        playAction.
          update(
            false);
        pauseAction.
          update(
            true);
        stopAction.
          update(
            true);
    }
    public void managerSuspended(org.apache.batik.bridge.UpdateManagerEvent e) {
        if (debug) {
            java.lang.String msg =
              resources.
              getString(
                "Message.updateManagerSuspended");
            java.lang.System.
              out.
              println(
                msg);
        }
        playAction.
          update(
            true);
        pauseAction.
          update(
            false);
    }
    public void managerResumed(org.apache.batik.bridge.UpdateManagerEvent e) {
        if (debug) {
            java.lang.String msg =
              resources.
              getString(
                "Message.updateManagerResumed");
            java.lang.System.
              out.
              println(
                msg);
        }
        playAction.
          update(
            false);
        pauseAction.
          update(
            true);
    }
    public void managerStopped(org.apache.batik.bridge.UpdateManagerEvent e) {
        if (debug) {
            java.lang.String msg =
              resources.
              getString(
                "Message.updateManagerStopped");
            java.lang.System.
              out.
              println(
                msg);
        }
        managerStopped =
          true;
        playAction.
          update(
            false);
        pauseAction.
          update(
            false);
        stopAction.
          update(
            false);
    }
    public void updateStarted(final org.apache.batik.bridge.UpdateManagerEvent e) {
        
    }
    public void updateCompleted(final org.apache.batik.bridge.UpdateManagerEvent e) {
        
    }
    public void updateFailed(org.apache.batik.bridge.UpdateManagerEvent e) {
        
    }
    protected class UserAgent implements org.apache.batik.swing.svg.SVGUserAgent {
        protected UserAgent() { super(); }
        public void displayError(java.lang.String message) {
            if (debug) {
                java.lang.System.
                  err.
                  println(
                    message);
            }
            javax.swing.JOptionPane pane =
              new javax.swing.JOptionPane(
              message,
              javax.swing.JOptionPane.
                ERROR_MESSAGE);
            javax.swing.JDialog dialog =
              pane.
              createDialog(
                JSVGViewerFrame.this,
                "ERROR");
            dialog.
              setModal(
                false);
            dialog.
              setVisible(
                true);
        }
        public void displayError(java.lang.Exception ex) {
            if (debug) {
                ex.
                  printStackTrace(
                    );
            }
            org.apache.batik.util.gui.JErrorPane pane =
              new org.apache.batik.util.gui.JErrorPane(
              ex,
              javax.swing.JOptionPane.
                ERROR_MESSAGE);
            javax.swing.JDialog dialog =
              pane.
              createDialog(
                JSVGViewerFrame.this,
                "ERROR");
            dialog.
              setModal(
                false);
            dialog.
              setVisible(
                true);
        }
        public void displayMessage(java.lang.String message) {
            statusBar.
              setMessage(
                message);
        }
        public void showAlert(java.lang.String message) {
            svgCanvas.
              showAlert(
                message);
        }
        public java.lang.String showPrompt(java.lang.String message) {
            return svgCanvas.
              showPrompt(
                message);
        }
        public java.lang.String showPrompt(java.lang.String message,
                                           java.lang.String defaultValue) {
            return svgCanvas.
              showPrompt(
                message,
                defaultValue);
        }
        public boolean showConfirm(java.lang.String message) {
            return svgCanvas.
              showConfirm(
                message);
        }
        public float getPixelUnitToMillimeter() {
            return 0.26458332F;
        }
        public float getPixelToMM() { return getPixelUnitToMillimeter(
                                               );
        }
        public java.lang.String getDefaultFontFamily() {
            return application.
              getDefaultFontFamily(
                );
        }
        public float getMediumFontSize() {
            return 9.0F *
              25.4F /
              (72.0F *
                 getPixelUnitToMillimeter(
                   ));
        }
        public float getLighterFontWeight(float f) {
            int weight =
              (int)
                ((f +
                    50) /
                   100) *
              100;
            switch (weight) {
                case 100:
                    return 100;
                case 200:
                    return 100;
                case 300:
                    return 200;
                case 400:
                    return 300;
                case 500:
                    return 400;
                case 600:
                    return 400;
                case 700:
                    return 400;
                case 800:
                    return 400;
                case 900:
                    return 400;
                default:
                    throw new java.lang.IllegalArgumentException(
                      "Bad Font Weight: " +
                      f);
            }
        }
        public float getBolderFontWeight(float f) {
            int weight =
              (int)
                ((f +
                    50) /
                   100) *
              100;
            switch (weight) {
                case 100:
                    return 600;
                case 200:
                    return 600;
                case 300:
                    return 600;
                case 400:
                    return 600;
                case 500:
                    return 600;
                case 600:
                    return 700;
                case 700:
                    return 800;
                case 800:
                    return 900;
                case 900:
                    return 900;
                default:
                    throw new java.lang.IllegalArgumentException(
                      "Bad Font Weight: " +
                      f);
            }
        }
        public java.lang.String getLanguages() {
            return application.
              getLanguages(
                );
        }
        public java.lang.String getUserStyleSheetURI() {
            return application.
              getUserStyleSheetURI(
                );
        }
        public java.lang.String getXMLParserClassName() {
            return application.
              getXMLParserClassName(
                );
        }
        public boolean isXMLParserValidating() {
            return application.
              isXMLParserValidating(
                );
        }
        public java.lang.String getMedia() {
            return application.
              getMedia(
                );
        }
        public java.lang.String getAlternateStyleSheet() {
            return alternateStyleSheet;
        }
        public void openLink(java.lang.String uri,
                             boolean newc) {
            if (newc) {
                application.
                  openLink(
                    uri);
            }
            else {
                showSVGDocument(
                  uri);
            }
        }
        public boolean supportExtension(java.lang.String s) {
            return false;
        }
        public void handleElement(org.w3c.dom.Element elt,
                                  java.lang.Object data) {
            
        }
        public org.apache.batik.bridge.ScriptSecurity getScriptSecurity(java.lang.String scriptType,
                                                                        org.apache.batik.util.ParsedURL scriptURL,
                                                                        org.apache.batik.util.ParsedURL docURL) {
            if (!application.
                  canLoadScriptType(
                    scriptType)) {
                return new org.apache.batik.bridge.NoLoadScriptSecurity(
                  scriptType);
            }
            else {
                switch (application.
                          getAllowedScriptOrigin(
                            )) {
                    case org.apache.batik.apps.svgbrowser.ResourceOrigin.
                           ANY:
                        return new org.apache.batik.bridge.RelaxedScriptSecurity(
                          scriptType,
                          scriptURL,
                          docURL);
                    case org.apache.batik.apps.svgbrowser.ResourceOrigin.
                           DOCUMENT:
                        return new org.apache.batik.bridge.DefaultScriptSecurity(
                          scriptType,
                          scriptURL,
                          docURL);
                    case org.apache.batik.apps.svgbrowser.ResourceOrigin.
                           EMBEDED:
                        return new org.apache.batik.bridge.EmbededScriptSecurity(
                          scriptType,
                          scriptURL,
                          docURL);
                    default:
                        return new org.apache.batik.bridge.NoLoadScriptSecurity(
                          scriptType);
                }
            }
        }
        public void checkLoadScript(java.lang.String scriptType,
                                    org.apache.batik.util.ParsedURL scriptURL,
                                    org.apache.batik.util.ParsedURL docURL)
              throws java.lang.SecurityException {
            org.apache.batik.bridge.ScriptSecurity s =
              getScriptSecurity(
                scriptType,
                scriptURL,
                docURL);
            if (s !=
                  null) {
                s.
                  checkLoadScript(
                    );
            }
        }
        public org.apache.batik.bridge.ExternalResourceSecurity getExternalResourceSecurity(org.apache.batik.util.ParsedURL resourceURL,
                                                                                            org.apache.batik.util.ParsedURL docURL) {
            switch (application.
                      getAllowedExternalResourceOrigin(
                        )) {
                case org.apache.batik.apps.svgbrowser.ResourceOrigin.
                       ANY:
                    return new org.apache.batik.bridge.RelaxedExternalResourceSecurity(
                      resourceURL,
                      docURL);
                case org.apache.batik.apps.svgbrowser.ResourceOrigin.
                       DOCUMENT:
                    return new org.apache.batik.bridge.DefaultExternalResourceSecurity(
                      resourceURL,
                      docURL);
                case org.apache.batik.apps.svgbrowser.ResourceOrigin.
                       EMBEDED:
                    return new org.apache.batik.bridge.EmbededExternalResourceSecurity(
                      resourceURL);
                default:
                    return new org.apache.batik.bridge.NoLoadExternalResourceSecurity(
                      );
            }
        }
        public void checkLoadExternalResource(org.apache.batik.util.ParsedURL resourceURL,
                                              org.apache.batik.util.ParsedURL docURL)
              throws java.lang.SecurityException {
            org.apache.batik.bridge.ExternalResourceSecurity s =
              getExternalResourceSecurity(
                resourceURL,
                docURL);
            if (s !=
                  null) {
                s.
                  checkLoadExternalResource(
                    );
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/gc4YTpByzEAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "8VzOcC7v6RHOXzsF569n5FdOw/lPz4Dz");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("zVniEwDfbTuct71BqvzCKRB/OyO/FRduyyASvje1Q/dqfvgm1fcdQ/GOoP/z" +
           "M0C/bzdOb7tnB/2e6wP9OLIvn5L3lYz8flx4wDRi3k4NR/TseOiztuPYrhEb" +
           "V52Kzk8dX4mPBPAHZxXA4wD4QzsBPHT9BfAfTsn7Txn592C+ORAAAM9maV89" +
           "wvfHZx3DzwBcT+7wPXn98X3zlLxvZeQbceFNAB9pTJXEiSnfiynFtZ31iTH8" +
           "p2fV49sAvmd2OJ+5/jj/1yl5383IfwchO8DJGrqduBnMgb0xTijzL88K8mkA" +
           "DtmBRK4PyGOO6qsZw975ayPduykjha1Gu7ZpgUGaQR0Z2fPlYPf2zgr2rwGQ" +
           "9A4s/QaBvfsUsPdm5HYQSwKwjfyDzGtiveOsozSbgd6zw/qe6269ew+fkvdo" +
           "Rh7YeqEuCJgTEA1Gl4/OvbdcDy9k7PAZ1x/f06fkFTNyaWuz2Up1EK8dY2AZ" +
           "4E1gTuB86qw4iwCfs8PpXH+c6Cl52f7AXiku3Adwjtlufp0gzFff3G5Zegwo" +
           "fNaQ6R0AYLwDGl9/oPgpeURG3gmA2tEhTklxbB2s+refHb12BPRdZ9XoIwDg" +
           "+3dA33/9gbKn5PUy0ooLN+/mFeWEEpmzYsuU+OIO24vXH9vklLwfzsgwLtwP" +
           "sOEOmEc8JTaOhuYJpOJZl6NVgPDDO6Qfvj5IT65kXstxGadgzmxz731An35g" +
           "eNlHuBnT0ZJ0TznroHw7QPexHcqPXR+UJ9cxe4tTAGaJe04MmkmCwA/jZhob" +
           "XrT73vzYoHTPqs5nAcBP7IB+4rqqM3/PNpCyLc9VWdvXfXc/u0xm7O59Xf4N" +
           "6/Yr3hz886cI5u9kJI0Ld1iKpzvGrr4T6l+fQSqPZIkQkMand1L59PWRyg1H" +
           "e9TMAfxHr9gN3l4hyu+viUI3w/JSDvvvnyKSH8/Ih7ZB80AL7SAeGFoS2vH6" +
           "oJ23XdGOGtq6aexfhT0X4I+e1axQILg/2gnwq9dfgLlgjqTzyasPtQP4Dx37" +
           "UnoH9bKtzL2fzcjH48JFICBt3vUVfSuYE2b102eQyu0HXuXPd1L58+s62E4I" +
           "5JTdrr1st2vv54FUgLlkbgXMF052fTH7+vqk4ZSuZTinFsyFdZYts9yEakBo" +
           "d23L3n7nGymsX7+mo977hznDb2TkV+PCWw7N4yT8E4by+e8HO3Bmtxye+1xb" +
           "8K9zJy0KCw9ccQ12e3VT+6VXLt785lfEf5PfxTq8XnlLt3DzNHGc4zcgjj1f" +
           "CEJjaudivGV7HyLIhfEv48Jjr9e5bIvx8CWfyr6wLfwaiDWvWjgu3Jj9HOf9" +
           "12B6OMkbF87nv8f5fh+0dsQXFy5sH46z/GFcuAGwZI9fygxo74V06xweOG5/" +
           "+cbCPa+nusMix+9zZSdr+V3lg1OwZHtb+Tntc6+0ufd/u/pz2/tkmqNsNlkt" +
           "N3cLN22vtuWVZidpj1+ztoO6LrSe/u6dv3zLUwdHfnduO3w0Fo717dGr39xq" +
           "ukGc37Xa/LM3/+o7f+GVP8mvbvw/9o67g0Q+AAA=");
    }
    protected static class ImageFileFilter extends javax.swing.filechooser.FileFilter {
        protected java.lang.String extension;
        public ImageFileFilter(java.lang.String extension) {
            super(
              );
            this.
              extension =
              extension;
        }
        public boolean accept(java.io.File f) {
            boolean accept =
              false;
            java.lang.String fileName =
              null;
            if (f !=
                  null) {
                if (f.
                      isDirectory(
                        )) {
                    accept =
                      true;
                }
                else {
                    fileName =
                      f.
                        getPath(
                          ).
                        toLowerCase(
                          );
                    if (fileName.
                          endsWith(
                            extension)) {
                        accept =
                          true;
                    }
                }
            }
            return accept;
        }
        public java.lang.String getDescription() {
            return extension;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfYxUVxW/M/u97DfsQhdYlmXAsOAM1ILBBSwsu7B0lt2w" +
           "dBMHy3DnzZ2Zx7557/Hend3ZRbSQKKuJhCJQ1Hb9h4ZKaGmqjRptg2m0bVpN" +
           "2qK1mlKjJqKVWGKsRtR67r3vzfuY2UUS4yTz5s1959x7zzm/8zvnvss3UYVp" +
           "oA6i0jCd1IkZ7lPpMDZMkuxVsGnug7G49GgZ/suBG3s2BVFlDDVksDkoYZP0" +
           "y0RJmjG0VFZNilWJmHsISTKNYYOYxBjHVNbUGGqVzYGsrsiSTAe1JGECo9iI" +
           "omZMqSEncpQMWBNQtDQKO4nwnUS2+R/3RFGdpOmTjvgil3iv6wmTzDprmRQ1" +
           "RQ/hcRzJUVmJRGWT9uQNtEbXlMm0otEwydPwIWWD5YLd0Q1FLuh6pvGD26cy" +
           "TdwF87GqapSbZ+4lpqaMk2QUNTqjfQrJmofRZ1FZFM1zCVMUitqLRmDRCCxq" +
           "W+tIwe7riZrL9mrcHGrPVKlLbEMULfdOomMDZ61phvmeYYZqatnOlcHazoK1" +
           "wsoiE8+uiZx59EDTs2WoMYYaZXWEbUeCTVBYJAYOJdkEMcxtySRJxlCzCsEe" +
           "IYaMFXnKinSLKadVTHMQftstbDCnE4Ov6fgK4gi2GTmJakbBvBQHlPWvIqXg" +
           "NNja5tgqLOxn42BgrQwbM1IYcGeplI/JapKiZX6Ngo2hB0AAVKuyhGa0wlLl" +
           "KoYB1CIgomA1HRkB6KlpEK3QAIAGRe2zTsp8rWNpDKdJnCHSJzcsHoFUDXcE" +
           "U6Go1S/GZ4Iotfui5IrPzT2bTx5Rd6lBFIA9J4mksP3PA6UOn9JekiIGgTwQ" +
           "inXd0XO47fnpIEIg3OoTFjLf+cyt+9d2XH1ZyCwuITOUOEQkGpcuJBpeX9K7" +
           "elMZ20a1rpkyC77Hcp5lw9aTnrwODNNWmJE9DNsPr+798acevkTeC6LaAVQp" +
           "aUouCzhqlrSsLivE2ElUYmBKkgOohqjJXv58AFXBfVRWiRgdSqVMQgdQucKH" +
           "KjX+H1yUgimYi2rhXlZTmn2vY5rh93kdIdQKX9SOUN1SxD/ilyIpktGyJIIl" +
           "rMqqFhk2NGa/GQHGSYBvM5EEoH4sYmo5AyAY0Yx0BAMOMsR6gHXdjJjj6YSh" +
           "TQAbRnaPjO4clckEMfohXUmYgU3//yyTZ9bOnwgEIBBL/DSgQAbt0pQkMeLS" +
           "mdz2vltPx18VEGNpYfmJovth5bBYOcxXDrOVw87KYd/KoYEs4L4fYgBfyCEU" +
           "CPANLGA7EiiAGI4BGwAd160eeWj3wemuMoCfPlEOAWCiXZ6y1OtQhs3zcelK" +
           "S/3U8uvrXwyi8ihqwRLNYYVVmW1GGvhLGrNSvC4BBcupG52uusEKnqFJJAm0" +
           "NVv9sGap1saJwcYpWuCawa5qLH8js9eUkvtHV89PHBv93LogCnpLBVuyAliO" +
           "qQ8zgi8QechPEaXmbTxx44Mr545qDll4ao9dMos0mQ1dfoj43ROXujvxc/Hn" +
           "j4a422uAzCmG5AOe7PCv4eGiHpvXmS3VYHBKM7JYYY9sH9fSDODJGeHYbeb3" +
           "CwAWjSw5OyBLu6xs5b/saZvOrgsF1hnOfFbwurFlRH/8Fz/9w8e4u+0S0+jq" +
           "DUYI7XHRGpushRNYswPbfQYhIPfO+eGvnL15Yj/HLEisKLVgiF17gc4ghODm" +
           "z798+O13r1+4FnRwTqGu5xLQHuULRlYzmxrmMBJWW+XsB2hRAc5gqAk9qAI+" +
           "5ZSMEwphifXPxpXrn/vTySaBAwVGbBitvfMEzvg929HDrx74WwefJiCxsuz4" +
           "zBETXD/fmXmbYeBJto/8sTeWfvUl/DhUDWBqU54inHwDVq6zTS2CLo1rsgoc" +
           "FhWYR3MDf7yOX+9jnuBKiD/bxC4rTXdWeBPP1VfFpVPX3q8fff+FW9wMb2Pm" +
           "BsEg1nsE7thlVR6mX+hnrV3YzIDcfVf3fLpJuXobZozBjBJwtDlkAJnmPZCx" +
           "pCuqfvnDF9sOvl6Ggv2oVtFwsh/z7EM1AHtiZoCH8/on7xdhn2A4aOKmoiLj" +
           "iwaY55eVjmlfVqc8ClPfXfjtzRdnrnP46WKOxQW6XeKhW97eOxl/6c2P/+zi" +
           "I+cmRIOwenaa8+kt+seQkjj+m78XuZwTXInmxacfi1x+rL1363tc32Eaph3K" +
           "F5czYGtH995L2b8Guyp/FERVMdQkWe30KFZyLH9j0EKado8NLbfnubcdFL1P" +
           "T4FJl/hZzrWsn+OcMgr3TJrd1/torYWFcAVkeqeV8Z1+WgsgfvMAV/kIv3az" +
           "y0dtFqnRDY3CLknSRyTNc0wLahBAopoW120U7Mmun2CXqJhrSylI5ktvJchu" +
           "h4DVTH5+cDbDYbrA32i5Wc2BI2I5t3S2Xpj38ReOn5lJDj2xXgCyxdtf9sHx" +
           "6amf/+u18Plfv1Kimam0zjLOgkG2ngf/g/yM4IDpnYbTv/1eKL39bjoNNtZx" +
           "h16C/V8GFnTPnlL+rbx0/I/t+7ZmDt5F07DM50v/lN8cvPzKzlXS6SA/EAmU" +
           "Fx2kvEo9XmzXGgROfuo+D8JXFKK/kEUVIl7XbUW/u3Th5philzXF5XA2VV99" +
           "8BWVOk6KshZmvShfJT1HQeFxTABEGJfr1NuFsniP5BImdIxyFhqEceuEde/w" +
           "QWk6NPw7gcV7SigIudYnI18efevQazxw1QwpBXe5UAKIcvU+TcIPH8InAN9/" +
           "sy/bLRsQJ5WWXuu41Fk4LzFyn5OlfQZEjra8O/bYjaeEAX5K9gmT6TNf+jB8" +
           "8oxILHHoXlF07nXriIO3MIdd+O6Wz7UK1+j//ZWj33/y6ImgFZsYRVUJTVMI" +
           "VouCDQ2f1+1irzu+2PiDUy1l/ZC1A6g6p8qHc2Qg6UVulZlLuOLgnNMdHFu7" +
           "Zj6nKNBt107OkdIcHPlflG020Kvz8QMFyLexZyGA+hYL8lvuPltmU50D/F+Y" +
           "49k0uxyjqCFN6A5iSoas2x3yRscZx/8XzshDO+Y7PdrJvO5uj6EAjEVFb77E" +
           "2xrp6ZnG6oUzD77FKb3wRqUOUjOVUxR33XbdV+oGScncJXWiiuv85zQcK++0" +
           "OYpqnT/cpEeE8lmKWksqU1TOftyy56FP9stSVMF/3XJfh9UcOcZo/MYtMkNR" +
           "GYiw22/otou7+CuDsDkB/XeYvUORMprGPOtEIx/w1upC+FvvFH5XeV/hYSf+" +
           "EtNO35x4jQnH+5nde47c2viEOK9JCp6aYrPMg6QVR8dCgVs+62z2XJW7Vt9u" +
           "eKZmpc0mzWLDTiItdqG9FzhFZy11u+8wY4YKZ5q3L2x+4SfTlW8AD+5HAUzR" +
           "/P3FPWNez0FnsT9aTE7QDPBTVs/qr01uXZv68694V46KenG/fFy6dvGhN08v" +
           "ugCnsXkDqAKIkuR5M7tjUt1LpHEjhuplsy8PW4RZZKx4mK+B4RyzwxX3i+XO" +
           "+sIoO+0DCIr5vPgdCZxgIM22azk1aXHnPGfE83bV7hFyuu5TcEZcNW9K0K0o" +
           "b2Xx6KCu2+WubL3OWeKIvwLwQa79LL9ll2/9B/K+GQvgGAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "kPY3krwJLUuTx8gyTbNalr2vvjUNxNHb");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("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" +
       "ytN+nHXxMsZ7LbXn0a/k2/n/B4MKh/IciwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "y0gCl5FVOZh1Fcq2l5OuWBFFrdURBiqs");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "84NiGhn0ethNuxLfzwS70qPkDK+J04Fo");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "Fz4jl//7XsjlnVu5vPM5kcvZ3Rd3rRw4lsmHLpBJPqx35adPblm8y+f9zD3o" +
       "4D60fUHEQ2deEHHXdvFzGyq/dgHN/5wnv5QUnjiimcZBbh6nid5yt8Hbqf3v" +
       "2hL9rueI6EcuIPrRPPnt4/oUjDh1z9D8nXtB8/u3NL//OaL5xxfQ/JM8+fiu" +
       "nbZP0vzE3dJsAXo/saX5E88Rzb+6gObn8uTPgcdKN5a92zhvuV3g7QRfP7tl" +
       "+bPPEcvPX8Ayf8HLlb9LCo8fsjwvFPn7u+VZAfx+YcvzF54bnvc9cD7P+67m" +
       "yaWk8Mghz13N8n2X9yGZAZmd2tIziKPCi06tv+JVzQZGcl37wHsff/CF75U+" +
       "cqlwZbvwKr/iVbrw4DR1nBPrq06utbo/iIyptWF/dZM+FmzYPJEUXnmrDUfz" +
       "93nc+CeHf9/jh4WfBgHZzsJJ4Ur+cTLvC4DbPp03Kdy3+TyZ74vA3Y7zJYX7" +
       "D7+czPLSpHAZZMm/vmzz9qS/yQ5b1RedUJvDdZa3fGPNjSJR4TU3LacL8sVw" +
       "R0vfUn77usIPvpdiv+Jz9e/brKO7T3PU9Tq/yoN04YF881v1cIlevnzuVede" +
       "7eha9xOv//xjP3r1tUdL/R47BHyswiewveJ4P9SOD0Lew/m5Z1A3SFb5TN/6" +
       "p1/4b978/e/9+Gbjzf8PU0vn04adAAA=");
}
