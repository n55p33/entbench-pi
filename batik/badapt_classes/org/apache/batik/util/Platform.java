package org.apache.batik.util;
public abstract class Platform {
    public static boolean isOSX = java.lang.System.getProperty("os.name").
      equals(
        "Mac OS X");
    public static boolean isJRE13 = java.lang.System.getProperty("java.version").
      startsWith(
        "1.3");
    public static void unmaximize(java.awt.Frame f) { if (!isJRE13) {
                                                          try {
                                                              java.lang.reflect.Method m1 =
                                                                java.awt.Frame.class.
                                                                getMethod(
                                                                  "getExtendedState",
                                                                  (java.lang.Class[])
                                                                    null);
                                                              java.lang.reflect.Method m2 =
                                                                java.awt.Frame.class.
                                                                getMethod(
                                                                  "setExtendedState",
                                                                  new java.lang.Class[] { java.lang.Integer.
                                                                                            TYPE });
                                                              int i =
                                                                ((java.lang.Integer)
                                                                   m1.
                                                                   invoke(
                                                                     f,
                                                                     (java.lang.Object[])
                                                                       null)).
                                                                intValue(
                                                                  );
                                                              m2.
                                                                invoke(
                                                                  f,
                                                                  new java.lang.Object[] { new java.lang.Integer(
                                                                    i &
                                                                      ~6) });
                                                          }
                                                          catch (java.lang.reflect.InvocationTargetException ite) {
                                                              
                                                          }
                                                          catch (java.lang.NoSuchMethodException nsme) {
                                                              
                                                          }
                                                          catch (java.lang.IllegalAccessException iae) {
                                                              
                                                          }
                                                      }
    }
    public Platform() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
