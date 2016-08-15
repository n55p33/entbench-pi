package org.apache.batik.apps.svgbrowser;
public class SVGOptionPanel extends org.apache.batik.apps.svgbrowser.OptionPanel {
    protected javax.swing.JCheckBox xmlbaseCB;
    protected javax.swing.JCheckBox prettyPrintCB;
    public SVGOptionPanel() { super(new java.awt.BorderLayout());
                              add(new javax.swing.JLabel(resources.getString(
                                                                     "SVGOptionPanel.label")),
                                  java.awt.BorderLayout.
                                    NORTH);
                              xmlbaseCB = new javax.swing.JCheckBox(
                                            resources.
                                              getString(
                                                "SVGOptionPanel.UseXMLBase"));
                              xmlbaseCB.setSelected(resources.getBoolean(
                                                                "SVGOptionPanel.UseXMLBaseDefault"));
                              add(xmlbaseCB, java.awt.BorderLayout.
                                               CENTER);
                              prettyPrintCB = new javax.swing.JCheckBox(
                                                resources.
                                                  getString(
                                                    "SVGOptionPanel.PrettyPrint"));
                              prettyPrintCB.setSelected(resources.
                                                          getBoolean(
                                                            "SVGOptionPanel.PrettyPrintDefault"));
                              add(prettyPrintCB, java.awt.BorderLayout.
                                                   SOUTH); }
    public boolean getUseXMLBase() { return xmlbaseCB.isSelected(
                                                        ); }
    public boolean getPrettyPrint() { return prettyPrintCB.isSelected(
                                                             ); }
    public static org.apache.batik.apps.svgbrowser.SVGOptionPanel showDialog(java.awt.Component parent) {
        java.lang.String title =
          resources.
          getString(
            "SVGOptionPanel.dialog.title");
        org.apache.batik.apps.svgbrowser.SVGOptionPanel panel =
          new org.apache.batik.apps.svgbrowser.SVGOptionPanel(
          );
        org.apache.batik.apps.svgbrowser.OptionPanel.Dialog dialog =
          new org.apache.batik.apps.svgbrowser.OptionPanel.Dialog(
          parent,
          title,
          panel);
        dialog.
          pack(
            );
        dialog.
          setVisible(
            true);
        return panel;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "bOODnPsV3mXNlf8A2UOW3JgaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aaewkx1Xv3fXueje2d23HR0x8r0PsMf/uOXsa55qe7jm6" +
       "Z/qYo+eAZNP3MX0fc3Ri4kSQWERyImKHAIn5QCJI5BwCQpBQkBGCJEqEFBRx" +
       "SSQRQiIQIuIPBESAUN3zv/cwVhAjdU1N1atX771679evquaF70GnoxAq+J69" +
       "0W0v3lHX8Y5lV3fija9GO1SvyolhpCpNW4yiEWi7LD/0uQs/+OEHjYsnoTNz" +
       "6HbRdb1YjE3PjQZq5NlLVelBFw5aSVt1ohi62LPEpQgnsWnDPTOKn+hBrzo0" +
       "NIYu9fZEgIEIMBABzkWAGwdUYNDNqps4zWyE6MZRAP0cdKIHnfHlTLwYevAo" +
       "E18MRWeXDZdrADjcmP0WgFL54HUIPbCv+1bnKxR+rgA/+8tvu/jbp6ALc+iC" +
       "6Q4zcWQgRAwmmUM3OaojqWHUUBRVmUO3uqqqDNXQFG0zzeWeQ7dFpu6KcRKq" +
       "+0bKGhNfDfM5Dyx3k5zpFiZy7IX76mmmait7v05rtqgDXe880HWrYStrBwqe" +
       "N4FgoSbK6t6QGxamq8TQ/cdH7Ot4iQYEYOhZR40Nb3+qG1wRNEC3bdfOFl0d" +
       "Hsah6eqA9LSXgFli6J5rMs1s7YvyQtTVyzF093E6btsFqM7lhsiGxNAdx8ly" +
       "TmCV7jm2SofW53vMG555h9txT+YyK6psZ/LfCAbdd2zQQNXUUHVldTvwpsd6" +
       "Hxbv/OLTJyEIEN9xjHhL84V3vvSWx+978ctbmp+4Cg0rWaocX5Y/Lt3y9dc2" +
       "H8VOZWLc6HuRmS3+Ec1z9+d2e55Y+yDy7tznmHXu7HW+OPjT2VOfUr97Ejrf" +
       "hc7Inp04wI9ulT3HN201bKuuGoqxqnShc6qrNPP+LnQW1Humq25bWU2L1LgL" +
       "3WDnTWe8/DcwkQZYZCY6C+qmq3l7dV+Mjby+9iEIOgse6CbwPAhtP/l3DEmw" +
       "4TkqLMqia7oezIVepn8Eq24sAdsasAS8fgFHXhICF4S9UIdF4AeGutsh+n4E" +
       "R0tdCr1VpIbwUGizfqYzJ7qqvZP5mv//Mss60/Xi6sQJsAyvPQ4CNoifjmcr" +
       "anhZfjbByZc+c/mrJ/eDYtdKMZRNvLOdeCefeCebeOdg4p2jE0MnTuTzvToT" +
       "YLvkYMEWIPQBKN706PCt1NuffugU8DV/dQOwdkYKXxubmwdg0c0hUQYeC734" +
       "kdW7hXchJ6GTR0E2Exo0nc+Gcxk07kPgpePBdTW+F973nR989sNPegdhdgS1" +
       "d6P/ypFZ9D503LyhJ6sKwMMD9o89IH7+8hefvHQSugFAAoDBWARuCxDmvuNz" +
       "HIniJ/YQMdPlNFBY80JHtLOuPRg7HxtgLQ5a8nW/Ja/fCmz8qsytXwOewq6f" +
       "599Z7+1+Vr566yfZoh3TIkfcNw79j/3Vn/1jOTf3HjhfOPS6G6rxE4cAIWN2" +
       "IQ/9Ww98YBSqKqD7249wH3rue+/7mdwBAMXDV5vwUlY2ARCAJQRm/oUvB3/9" +
       "rW9+/BsnD5wmBm/ERLJNeb2vZNYOnb+OkmC21x3IAwDFBuGWec2lset4iqmZ" +
       "omSrmZf+54VHip//52cubv3ABi17bvT4yzM4aH8NDj311bf92305mxNy9kI7" +
       "sNkB2RYlbz/g3AhDcZPJsX73n9/7K18SPwbwFmBcZKZqDltQbgMoXzQ41/+x" +
       "vNw51lfMivujw85/NL4OJR6X5Q9+4/s3C9//w5dyaY9mLofXui/6T2zdKyse" +
       "WAP2dx2P9I4YGYCu8iLzsxftF38IOM4BRxmgWMSGAG/WRzxjl/r02b/5oz++" +
       "8+1fPwWdbEHnbU9UWmIeZNA54N1qZACoWvtvfst2cVc3guJirip0hfJbp7g7" +
       "/5Xlfo9eG19aWeJxEKJ3/wdrS+/5u3+/wgg5slzlfXts/Bx+4aP3NN/03Xz8" +
       "QYhno+9bX4nBIEk7GFv6lPOvJx868ycnobNz6KK8mwEKop1kgTMHWU+0lxaC" +
       "LPFI/9EMZvu6fmIfwl57HF4OTXscXA6wH9Qz6qx+/hie3JJZ+SHwPLIbao8c" +
       "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" +
       "AAA=");
}
