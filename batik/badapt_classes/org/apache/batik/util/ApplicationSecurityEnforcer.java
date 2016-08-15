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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tVFXndWiMzXW03nVRE1zQbRSqCmHFJvo6wFt93Yo2aJcu2bWZxBtt2pVimWE" +
       "utZWNiytbGC+2d7I9WgHR9p2jeqWE4orkoQliMXHenu8ITC8pdl208zG68xE" +
       "mi1zOqLR1bYhhzpat5c1TjOg7jIl/Ik4aKMJz3v+TDDINUZOxnBr10I6mGJj" +
       "WZh53X6gmBEB41Zth8lqP8dDr6sMRhs6Npa4ItH9seMxy1ZSp1VGb7tB1Kri" +
       "DrVkDbuJWT1y6TB0nOKBnUwDvN0ZrylDr6cNodWAYNSZdGHJpiY7xoTnLY9B" +
       "hxBnLI225dWNxTjfzRf1HjeK0UEAm469AAHSJu6q6pSXvCSx6qTqi0tzCkIr" +
       "pksoC6WHS6twwTVgNhrmjdXAybW2pvXa274vd5v82ELTbSvzuDxYucuFlm71" +
       "Jp2yHAMs0mC70tXAVXctsI3rZL1otmwgfK+tLVhEHSP1mM1RvFMboOt5nx95" +
       "BL4z+3gyhMcUM57V/SRwKH046vd20Fo2TWKR9ijB1yFzwc2BxcvYicywzfpA" +
       "J91RDW3PEYHZWfUJjvOjyXa+4/3Wmickjl6EboMLutqcUesCTYmOwswQIQqz" +
       "jRz3NrO2AyH10azuCviUGVmtCRm01xohi1w4dYme0GDh9Woir3d2bHFwtZNj" +
       "MKOZXEO2kmzec2lmaVOjhW4oixHmVSF+Cum9HA0Vq72A5wA9ZKo5iBbilbJY" +
       "u4nv9DvaiFuzpsCZVSJWw8miIcgRgiKeK0Iui+ktdZyFvFBfiW2jtxkN2np/" +
       "1JN2VFbl51hrulxzzXFzB9twb4Pj7aoK1ykSNyJzubImFh4huaKFCbttTu1+" +
       "Y6jN8NUOCWcOZPmORkuUj3I2lQtQyo8UfLNSUTPlpEHdG/p0c1Ilp9VkOUiW" +
       "addu1n27m6I1qpYMmbS6HvtaQxVSqqnYXdvtKZzYqVLNjhXkwJ5tdphVrQbb" +
       "+jBF0DXRJfBZjekNUbgz81l84I+RoZgGM15FMybD13HcylZYVd4IK8QB8YiK" +
       "bpvdaGO0u4lISOOJ4AZVozZIRpkeorrBR8xqPWW9yVbROtWOykcCW81awOjL" +
       "bIdR6gE0bsCrhrMKNNMlzbw9cHbMCA2JdDibB6qh8joRg34WowxHMpIjdz4e" +
       "BTKn7mw3iqEAa9geBPZLfnNGxVBqGeuOR+8SXx9YnfpW5tEmAbVcIGrOcDrA" +
       "ZmX52hWlGA/kqBq15x1kKGj5VnSH0JKisPUuqY52jYmXDBPcTjvz+TDTZtQi" +
       "RQxziqLAZYOIw5oMFiKZ1nsQMQms1OJ1GY3beD32+hbHTFShK27FMI77BI+k" +
       "i/5o1lgsMm7ZSYlGW+403Hy9ZOsLHO7otB0P4io669kby3STTa2zqSo9wY3X" +
       "vhLzGyqqr4PUbcMDpB23zfFaikAQTqy2nj2uD4fOqJ1tXT426FCnA5RxGIVZ" +
       "sVIVY/A17nQ7m6nGLaAG1jBlUZbiOW6O1nO+j1qoZmzNZb873Y2pwDK49cze" +
       "NJzYQ1B5QYQ9bDlRpsv6ZsAES4Wstq1Nz1CasdaPpHA4WPbjZRj4qyqKcf1t" +
       "PRivR9JWq0ZbJevH1UwwsXqv78URKy9FLFm2Q6VDsXnAaySpxY1uaHTbs3jc" +
       "R5ga63Z8aKFMHFJtyhoTwkO7mxBJw+/lgVDbMUJQ3dGMS0AOS2jauLeSaoiV" +
       "eMGYazrCesnRSbvJ0Bq8ASmMXR/nlZnY4dPWwPeTIUFz/cyivACP5qzoUind" +
       "QJGkCTtCOInICVWP6BGwGaPdrLPYdp2RtFgNa7peW9BbJ8e3EDoNMbkDeYOe" +
       "19z6ZqON6DDUH+e0oG06EMzR8/o4caARy+7YYR12NjQd8xqsbeyVzrGizGrV" +
       "YDaJx9SmRkmUB7HyQHc8PJJwYoYasZf1tnWivrE6eUJ3UX2L+lttamgYbJLp" +
       "rjtatxmIRfwqb7M7ppHyFBfoOjqLiCpkoW1n3OPb6hg2VYqUZIgMm70qBlcb" +
       "Td+Vp1XNXM6MhTFl5kynIUz4ZFjn9XybgUh+PKFrGervZgNtIfjxOl7wszBb" +
       "mmZdXlSxwN3ORcsiuwIyrfaFOTJnxn2x");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ychRw9lMcJpJ0bm8bnWgHiNbOQrhq7YsYR09CuJJsyPNdlGtqSSUmjfT4bI/" +
       "oVsWO+vW+SQeha7JDalcpdCxuPKULc8wGB3CDhFQRk+WdFlqYXWB8TqkLqg+" +
       "cErQhrZWQ2lDO0GnDYtITDfthcJrkjyA/V5ICxmsDdEu5+TAImRzsP0yFREO" +
       "mF0KJ96KiLHFSnEpNfYDybOz9qTWm6edsGmveKZfE1O0BXXW7ZHews0kxDDs" +
       "J4ojqd+/vVPBB8vDzuNrot/HMWd+3m2J8u/uypmrhadOlU9dPKgUJ3xP3ez2" +
       "Z3m69/mPvva6wf8ycnSv5t+llfvSMHqvZ65N71RXxU3nF29+ksmWl19PLhL8" +
       "9kf/xxOT99uv3MYVuneewXm2y3/EvvE7/Xfrv3CxcsfxtYIbruVe3+jl6y8T" +
       "XIrNNIuDyXVXCp66/goLDNJnDyX72fM+q1y5xWH9e/Zzf+ZOyYU9Qfn+5VNz" +
       "/pW0cs88DD1TC8p237jFXZRvFtkfpZXL5v7z+9Fh/nmd3rkOHeNEw/74dq6t" +
       "lAVfPxZJ8cW28g6QvnQoki/9cERymrW/uEXdXxbZt9PK/ZaZ7j8cSQJz9LHj" +
       "/vI8PzDTg6PCkt/v/AD8lirwHpB+95Df3/2h83vh3lvUXSqyO9LKo87+y845" +
       "32z+7JjTC3f+AJwWl5MrKAB9177t/vetcgo0N4qdtZaat9L40t6VfD1yC54f" +
       "K7LLaeVSYqYDLcYPv0af4vPKD4PPlw75fOk2Z/TCw2+NxWdvweJzRfbknsWu" +
       "uT6Hxadu625ZWnnHLW7mFNc9H7/hHzP2/0yg/+rrl+997HXpP5aXhI8v/N/H" +
       "VO5dZJ53+ubVqee7o9hcOKUc7tvfw4pKvl5MK4+c+8URGKHip0B+4YU97XvT" +
       "ypWztGnlrvL3NB0MxHRCl1bu3j+cJqmnlTsASfHYiI6swamve/vLZ/mF6z3h" +
       "sYF46HvJ+pTzfO46l1f+U8yRe8pGh3dgv/j6gPvpb7V+eX9/Wfe03a7o5V6m" +
       "cs/+KvWxi3v2pr0d9XU39cJ3H/i1+54/cscP7AGf6OgpbO88/7Iw6Udpeb13" +
       "988f+6c//g9e/8Py8+b/A4IPx7utNAAA");
}
