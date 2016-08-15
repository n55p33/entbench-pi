package org.apache.batik.dom.events;
public class DOMUIEvent extends org.apache.batik.dom.events.AbstractEvent implements org.w3c.dom.events.UIEvent {
    private org.w3c.dom.views.AbstractView view;
    private int detail;
    public org.w3c.dom.views.AbstractView getView() { return view; }
    public int getDetail() { return detail; }
    public void initUIEvent(java.lang.String typeArg, boolean canBubbleArg,
                            boolean cancelableArg,
                            org.w3c.dom.views.AbstractView viewArg,
                            int detailArg) { initEvent(typeArg, canBubbleArg,
                                                       cancelableArg);
                                             this.view = viewArg;
                                             this.detail = detailArg; }
    public void initUIEventNS(java.lang.String namespaceURIArg, java.lang.String typeArg,
                              boolean canBubbleArg,
                              boolean cancelableArg,
                              org.w3c.dom.views.AbstractView viewArg,
                              int detailArg) { initEventNS(namespaceURIArg,
                                                           typeArg,
                                                           canBubbleArg,
                                                           cancelableArg);
                                               this.view = viewArg;
                                               this.detail = detailArg;
    }
    protected java.lang.String[] split(java.lang.String s) { java.util.List a =
                                                               new java.util.ArrayList(
                                                               8);
                                                             java.lang.StringBuffer sb;
                                                             int i =
                                                               0;
                                                             int len =
                                                               s.
                                                               length(
                                                                 );
                                                             while (i <
                                                                      len) {
                                                                 char c =
                                                                   s.
                                                                   charAt(
                                                                     i++);
                                                                 if (org.apache.batik.xml.XMLUtilities.
                                                                       isXMLSpace(
                                                                         c)) {
                                                                     continue;
                                                                 }
                                                                 sb =
                                                                   new java.lang.StringBuffer(
                                                                     );
                                                                 sb.
                                                                   append(
                                                                     c);
                                                                 while (i <
                                                                          len) {
                                                                     c =
                                                                       s.
                                                                         charAt(
                                                                           i++);
                                                                     if (org.apache.batik.xml.XMLUtilities.
                                                                           isXMLSpace(
                                                                             c)) {
                                                                         a.
                                                                           add(
                                                                             sb.
                                                                               toString(
                                                                                 ));
                                                                         break;
                                                                     }
                                                                     sb.
                                                                       append(
                                                                         c);
                                                                 }
                                                                 if (i ==
                                                                       len) {
                                                                     a.
                                                                       add(
                                                                         sb.
                                                                           toString(
                                                                             ));
                                                                 }
                                                             }
                                                             return (java.lang.String[])
                                                                      a.
                                                                      toArray(
                                                                        new java.lang.String[a.
                                                                                               size(
                                                                                                 )]);
    }
    public DOMUIEvent() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZC4wV1Rk+9+6TfbDL8hRheS1rFuFeUak1S63Lssji3UdZ" +
       "WOOCLnPnnrs7MHdmnDl39+5afCUttI3GKiJU3aQRC6UI1tRo02ppTEWDNRGp" +
       "lhKxD6NWSwqxtU1ta///nJk7j/sgJGWTOTtzzn/O+Z/f/59zD50lZZZJGqnG" +
       "ImzMoFakQ2O9kmnRRLsqWdYG6BuUHy2RPr39o+7rw6R8gEwelqwuWbLoGoWq" +
       "CWuAzFU0i0maTK1uShM4o9ekFjVHJKbo2gCZrlidKUNVZIV16QmKBP2SGSNT" +
       "JMZMJZ5mtNNegJG5MeAkyjmJtgWHW2OkRtaNMZd8loe83TOClCl3L4uR+thW" +
       "aUSKppmiRmOKxVozJrnS0NWxIVVnEZphka3qClsF62IrclSw8Jm6zz5/cLie" +
       "q2CqpGk64+JZ66mlqyM0ESN1bm+HSlPWHeQuUhIj1R5iRppizqZR2DQKmzrS" +
       "ulTAfS3V0ql2nYvDnJXKDRkZYmSBfxFDMqWUvUwv5xlWqGS27HwySDs/K62Q" +
       "MkfER66M7nr09vpnS0jdAKlTtD5kRwYmGGwyAAqlqTg1rbZEgiYGyBQNjN1H" +
       "TUVSlXHb0g2WMqRJLA3md9SCnWmDmnxPV1dgR5DNTMtMN7PiJblD2V9lSVUa" +
       "AllnuLIKCddgPwhYpQBjZlICv7OnlG5TtAQj84IzsjI23QwEMLUiRdmwnt2q" +
       "VJOggzQIF1ElbSjaB66nDQFpmQ4OaDIyu+CiqGtDkrdJQ3QQPTJA1yuGgGoS" +
       "VwROYWR6kIyvBFaaHbCSxz5nu1c+cKe2VguTEPCcoLKK/FfDpMbApPU0SU0K" +
       "cSAm1iyJ7ZZmvLgzTAgQTw8QC5rnv37+xqWNR18VNJfnoemJb6UyG5T3xSe/" +
       "Oae95foSZKPS0C0Fje+TnEdZrz3SmjEAYWZkV8TBiDN4dP0rt95zkH4SJlWd" +
       "pFzW1XQK/GiKrKcMRaXmTVSjpsRoopNMolqinY93kgp4jykaFb09yaRFWScp" +
       "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" +
       "JczgQZ6DzwJIoA1V8Fd8q/wfK9uYmVcfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3T/1yl8U2cD/C+tli5uOKgAA");
}
