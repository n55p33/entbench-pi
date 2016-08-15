package org.apache.batik.dom.events;
public abstract class AbstractEvent implements org.w3c.dom.events.Event, org.apache.batik.dom.xbl.OriginalEvent, java.lang.Cloneable {
    protected java.lang.String type;
    protected boolean isBubbling;
    protected boolean cancelable;
    protected org.w3c.dom.events.EventTarget currentTarget;
    protected org.w3c.dom.events.EventTarget target;
    protected short eventPhase;
    protected long timeStamp = java.lang.System.currentTimeMillis();
    protected boolean stopPropagation = false;
    protected boolean stopImmediatePropagation = false;
    protected boolean preventDefault = false;
    protected java.lang.String namespaceURI;
    protected org.w3c.dom.events.Event originalEvent;
    protected java.util.List defaultActions;
    protected int bubbleLimit = 0;
    public java.lang.String getType() { return type; }
    public org.w3c.dom.events.EventTarget getCurrentTarget() { return currentTarget;
    }
    public org.w3c.dom.events.EventTarget getTarget() { return target;
    }
    public short getEventPhase() { return eventPhase; }
    public boolean getBubbles() { return isBubbling; }
    public boolean getCancelable() { return cancelable; }
    public long getTimeStamp() { return timeStamp; }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public org.w3c.dom.events.Event getOriginalEvent() { return originalEvent;
    }
    public void stopPropagation() { this.stopPropagation = true; }
    public void preventDefault() { this.preventDefault = true; }
    public boolean getDefaultPrevented() { return preventDefault;
    }
    public java.util.List getDefaultActions() { return defaultActions;
    }
    public void addDefaultAction(java.lang.Runnable rable) { if (defaultActions ==
                                                                   null)
                                                                 defaultActions =
                                                                   new java.util.ArrayList(
                                                                     );
                                                             defaultActions.
                                                               add(
                                                                 rable);
    }
    public void stopImmediatePropagation() {
        this.
          stopImmediatePropagation =
          true;
    }
    public void initEvent(java.lang.String eventTypeArg,
                          boolean canBubbleArg,
                          boolean cancelableArg) {
        this.
          type =
          eventTypeArg;
        this.
          isBubbling =
          canBubbleArg;
        this.
          cancelable =
          cancelableArg;
    }
    public void initEventNS(java.lang.String namespaceURIArg,
                            java.lang.String eventTypeArg,
                            boolean canBubbleArg,
                            boolean cancelableArg) {
        if (namespaceURI !=
              null &&
              namespaceURI.
              length(
                ) ==
              0) {
            namespaceURI =
              null;
        }
        namespaceURI =
          namespaceURIArg;
        type =
          eventTypeArg;
        isBubbling =
          canBubbleArg;
        cancelable =
          cancelableArg;
    }
    boolean getStopPropagation() { return stopPropagation;
    }
    boolean getStopImmediatePropagation() {
        return stopImmediatePropagation;
    }
    void setEventPhase(short eventPhase) {
        this.
          eventPhase =
          eventPhase;
    }
    void stopPropagation(boolean state) {
        this.
          stopPropagation =
          state;
    }
    void stopImmediatePropagation(boolean state) {
        this.
          stopImmediatePropagation =
          state;
    }
    void preventDefault(boolean state) { this.
                                           preventDefault =
                                           state;
    }
    void setCurrentTarget(org.w3c.dom.events.EventTarget currentTarget) {
        this.
          currentTarget =
          currentTarget;
    }
    void setTarget(org.w3c.dom.events.EventTarget target) {
        this.
          target =
          target;
    }
    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        org.apache.batik.dom.events.AbstractEvent newEvent =
          (org.apache.batik.dom.events.AbstractEvent)
            super.
            clone(
              );
        newEvent.
          timeStamp =
          java.lang.System.
            currentTimeMillis(
              );
        return newEvent;
    }
    public org.apache.batik.dom.events.AbstractEvent cloneEvent() {
        try {
            org.apache.batik.dom.events.AbstractEvent newEvent =
              (org.apache.batik.dom.events.AbstractEvent)
                clone(
                  );
            newEvent.
              originalEvent =
              this;
            return newEvent;
        }
        catch (java.lang.CloneNotSupportedException e) {
            return null;
        }
    }
    public int getBubbleLimit() { return bubbleLimit;
    }
    public void setBubbleLimit(int n) { bubbleLimit =
                                          n;
    }
    public AbstractEvent() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "G8JkO34dirwUvJu+/ENVPmsDFWAN38Pjm5KI7EKXy2eNJypgRhbkYUwTvR0c" +
       "df5NCfuaAYu+5JMxUqkF1XJAst9FtL98MniifKf0EkNtChjBcxHRcWDEDjMS" +
       "9ExTfmR8OYzkIMAsMD88gNJWdGTYOeYqP36quW7eqV3fY1845I+izkiQutGs" +
       "pgWPSATua2ECHlUZlTNYOpN92h2dhNBfMCooqXVuUPXoIUfmMCWzS8lQUgVp" +
       "sOQRcEjhkuCx2P9guY/BcPXLQaPOTbDIJ6B2KIK3R02ut8s5jnRBkHD2TcCc" +
       "qfopLxI8lYafeLAD3t7nGNkB9/ups6du7b/j0ns+55yKkzVpchJraUiQac7Z" +
       "O1ZpVdG3WMHavLpqt3a+23Ru+nLv45eCU3lB3Zi1gAGzE2zzQ8fE7I78abEf" +
       "nL7xqW8eq/12lER2k4hEyazdxSdwcmbWIot2J4pPEwxJFju/1tV58tCm1aO/" +
       "epmdcSLO6YOF/PIj8gsP7/3OvW2n26OkoY/UqHpKybGjQTcf0nco8kFrmDSq" +
       "dm8OVIRaVEkrOKrQhKYs4VEZxotLZ2P+KR6XpGRZ8UmN4kOm9ZoxoVibjazO" +
       "tp4bE6TBf+L0TOirGJhjQwL+E7crMR3FJJbD3gB7HElsM03vrCGZNNlw5n9j" +
       "HT3JbvHuM/8H+Pn3M/xBAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ERBZ5+fr8RiIiblU3RohVAah1HD0RRAU");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("7Kldb4TLZNEJG0XLnZaiYGkrHcLyqhFCyywbYrWG4+U1xGpPWqroSvCojKHV" +
       "MWqhhfYAjnsabGFId1hhGZTpBwXOUOeoXnURTeWC6rRVJJdpwWM1EGTmKxbl" +
       "0ZrpCHOvzFs0UI2V1iQRo+UJat0eyiJY2EarhmI0l/NkkXiLXiWTS6UiCvoq" +
       "sokhEhutLteOrU63bcwn5enYUSsm08TyfNrvU5zcmAtxKgxaXQuuKZSUX/ad" +
       "JWd5RJDEYVRKaaUHlh9qV2lwUh9pu91KZ2lRTSfoBSMwKUFaHkbw0Yjos77V" +
       "MIFdJ5Q3tA0T7qQzBhfwqQcVOri0FDwbb/YCFyz7Q5vW2cmIQ2wbxCBzsSMR" +
       "KVSuUWalELkOohbG3SautoleMFAR3SrbOjJ35sbA65ZQp9tBiDldKstGkIwW" +
       "BJjmMGrM2GGrPWlQJYQx7UqvW8OAxoLQh1h6GquLc36UDBdsQZLVCoWqsdDg" +
       "43yF6Kcjf94uTolGGNXbEVlH+sCPqT21gM2pCNXNppTirDRpYS2zz9WxdKja" +
       "LELzIDDqN8J+C0E0ipjInSFPK7zPlKp+PKkp/rik8kWkXOkCBQOo46gTetqE" +
       "4RrDWIAxFLdGM2tI8bRH1WEdlnWqqfZR1/Wn43jETN3uSLX76GTFIRYIjMde" +
       "SA9YCTP1eYymMFPXYh5qSsyUHAgMPRRbXaLahHvdXoktwHGEhBXTYZtzvAUP" +
       "JVTyVdcj0y5i8YKqkI1WKao5HWrerEOxF1bluCZCZsEJ85XKsjdfjT1JJwJh" +
       "ZAwEqTajizNvLHdKkz4uLEjPj0pCHi6xcd4hF+WKgo5KVrM0M4pao7PC4NVq" +
       "gKhYrVtDBBFTHbKW+hNE8aEi0HUWnpd1bCms5JSTE8kWJ103gomyx2BJSrTN" +
       "GCpG4woSoXZRoCHFs2WJI+kqT7chpmsiWsjUoBK9mMAOXKXnLg+NfNzrLcWO" +
       "OQCaWXAkF5m3A7vF+bKN0OMuK4yxeUAD9dF7fFgeYzMQjZNggZ3vsdWp12Fn" +
       "yMimynPars/c1B0boims6Mgri1h12FTzZGFIG0GH0M1BQuaxmhT02VKbIMRW" +
       "SWvWcMwK+4XSIkA7M4qykopTN/FhiRAXeNyHEDzPOKU+lDYbjcZbslvU/+76" +
       "bpPfs777f3nT8cu4758e3+Du9qnDrcJ292V6+fHK+u9Cbrt7de//gccra8kH" +
       "93F/Yu8xz+uP3eaZitYl+rjncvftP1xALddRsg0X2W6Th0/auLzeafLxdz//" +
       "gkx/orj3PGqYPRp3vacsZaFYB6A9DGp608lPuPrrfdv7e6Z+691/9tDwGf0d" +
       "17Er9NEjOI9W+Yv9F7/Yeb30M7u5Gy7voLpiR/nhQk8f3jd1e6BEceAMD+2e" +
       "evjySGXP3nI/kA34dqSSow/C9hXl+Kdgb9wo2jrv+K1///OUvO9kyZ9FuVvA" +
       "6mwPY3tfLb95tYc2B+tbX/iTy9QeyC6+ARzv2lJ71/lT+/4peX+VJd+NcncD" +
       "aujBbTfZdWWf41+cleNj4PipLcefOneOO7eckndbluwC88mG7xhyOzecgdza" +
       "kzwCjp/ekvvp8yd33yl5r8qSu6LcKwAt7PI2n0wy3id44QwE78suPgyOj24J" +
       "fvT8CT56St7jWfJQlLsdEFxvJNwMHLvP7tVnZZfp5se37D5+/uzyp+Q9lSWv" +
       "3wwfeng73j7BN5yB4FrsNeD4zJbgZ86fYO2UvHqWwFHuzsz49nZ2ZYLv3OdX" +
       "OgO/9dyQ7d777JbfZ8+fH3pKHpYlz0S5C4AfdXS/0D7FHz6ri8kofmFL8Qvn" +
       "T5E+JW+QJcRmjjgU4GTCn9jneNWNrKdwvGOP45e2HL90/hx/5JS8t2fJ+Mot" +
       "fWvho3sQF64h79OenJX2Y+D4ypb2V86ftnlKXvY+3I5y3Da8nWf3GapndbCv" +
       "B8fXtwy/fv4MF6fkrRMfBOHZnfUNO2bDVZH9w242OKubzfT3m1ua3zx/mu8+" +
       "Je89WfIcWEjt09zbZZeJf+qwxl24GtBfWSf7XfPjZ9XxAji+vW3x2+fTNTvb" +
       "N+Oy32CVde/+KouNHWe9yMqgf/CUXns+S94PPJsgy4d67YgBXHV77NXoZ697" +
       "fG9L/3vnrxkvnJL3C1nykdP3Ax/ketVNrdcw1Dv3bsru3H0+XG/YX4Sv7wms" +
       "twiza3qfPIX6i1nyCRD4G44R7c1YB7n+w7NyhQHsR7dcX3M+XG9cC9x4metR" +
       "wv/sFMKfy5J/EuXuuEyY4o5Q/uUzUL4zuwjWOjtPbik/eR2Uc1fV4n95St6/" +
       "zpLPAysH/o07Ztf9PsEvnJUgWI3vPLUl+NS5Evy9U/L+TZZ8Mcq9ekvwxJ37" +
       "+0x/5wxM1xffCBgWt0yLZ2a6s6/Z8ZrSH55C9ytZ8u/Buic8smw9qKt/cFaC" +
       "2VBWtgQr50lwY4r/7RSC38iS/3LsOyIHKf7xWSlm3nb71tXOFW9dnZ3i/zqF" +
       "4v/Okm9d+8zyP87KFYSRO2/Zcn3L+XP965O57mZN7XzvaoHyX56VYRkAamwZ" +
       "Ns6T4ToW2r39FIZ3ZslNIBYKr7wTeIDj7s3nMYrYliN2/hzvP4Xjg1lyDwgI" +
       "QuV4cvee9U7EA7nsPZUNOfI6yF1boLf7xPHs179BDHzxyJMGyo242PPcACx2" +
       "sFRSvMwq1xVlTe8+HOVukjK5vfIHXoPYvBK93zOPnKFnslv3uddmb1Fse2Z8" +
       "/j0Dn5JXzpKnshdeM7LHvBK1e+kM7LLFVHaDdEfaspPOn90zp+Rlr6Xs1oFr" +
       "unyDdP2OTyb6a/sM33zWUPd1AKy5ZWieD8MDtvtrayrEKTTJLMEAzfAozYMG" +
       "3L4emimIPw59lSX7rMSDV3z0afOhIulTL1y49YEXRv9h/WGSyx8Tuo3M3arG" +
       "lnXwKwAHzm8G84VqrNnftk7v8tZsOBDpnfKxmCh38+Ykw7zLbsqMo9wrjysT" +
       "5W4A6UFJHpjyUUlg6+v/B+XeBmxiXw40ujk5KPIsqB2IZKfvyAZ7943pxt08" +
       "eFBXsr7PXdV5Xi5y8Ism2RPL9ee49p4uxsz21b9Pv0BQP/ad6ic2X1SRLGG1" +
       "ymq5lczdsvm4y7rS7Anl4yfWtlfXzfiT37/rM7e9bu9p6l0bwPt6ewDbo8d/" +
       "sgSzvWj9kZHV5x74pz/0j174o/W7Yf8PQM8SPCdNAAA=");
}
