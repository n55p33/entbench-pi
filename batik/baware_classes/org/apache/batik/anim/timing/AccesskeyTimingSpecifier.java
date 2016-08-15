package org.apache.batik.anim.timing;
public class AccesskeyTimingSpecifier extends org.apache.batik.anim.timing.EventLikeTimingSpecifier implements org.w3c.dom.events.EventListener {
    protected char accesskey;
    protected boolean isSVG12AccessKey;
    protected java.lang.String keyName;
    public AccesskeyTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                    boolean isBegin,
                                    float offset,
                                    char accesskey) { super(owner,
                                                            isBegin,
                                                            offset);
                                                      this.accesskey =
                                                        accesskey;
    }
    public AccesskeyTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                    boolean isBegin,
                                    float offset,
                                    java.lang.String keyName) {
        super(
          owner,
          isBegin,
          offset);
        this.
          isSVG12AccessKey =
          true;
        this.
          keyName =
          keyName;
    }
    public java.lang.String toString() { if (isSVG12AccessKey) {
                                             return "accessKey(" +
                                             keyName +
                                             ")" +
                                             (offset !=
                                                0
                                                ? super.
                                                toString(
                                                  )
                                                : "");
                                         }
                                         return "accesskey(" +
                                         accesskey +
                                         ")" +
                                         (offset !=
                                            0
                                            ? super.
                                            toString(
                                              )
                                            : ""); }
    public void initialize() { if (isSVG12AccessKey) { org.apache.batik.dom.events.NodeEventTarget eventTarget =
                                                         (org.apache.batik.dom.events.NodeEventTarget)
                                                           owner.
                                                           getRootEventTarget(
                                                             );
                                                       eventTarget.
                                                         addEventListenerNS(
                                                           org.apache.batik.util.XMLConstants.
                                                             XML_EVENTS_NAMESPACE_URI,
                                                           "keydown",
                                                           this,
                                                           false,
                                                           null);
                               }
                               else {
                                   org.w3c.dom.events.EventTarget eventTarget =
                                     owner.
                                     getRootEventTarget(
                                       );
                                   eventTarget.
                                     addEventListener(
                                       "keypress",
                                       this,
                                       false);
                               } }
    public void deinitialize() { if (isSVG12AccessKey) {
                                     org.apache.batik.dom.events.NodeEventTarget eventTarget =
                                       (org.apache.batik.dom.events.NodeEventTarget)
                                         owner.
                                         getRootEventTarget(
                                           );
                                     eventTarget.
                                       removeEventListenerNS(
                                         org.apache.batik.util.XMLConstants.
                                           XML_EVENTS_NAMESPACE_URI,
                                         "keydown",
                                         this,
                                         false);
                                 }
                                 else {
                                     org.w3c.dom.events.EventTarget eventTarget =
                                       owner.
                                       getRootEventTarget(
                                         );
                                     eventTarget.
                                       removeEventListener(
                                         "keypress",
                                         this,
                                         false);
                                 } }
    public void handleEvent(org.w3c.dom.events.Event e) {
        boolean matched;
        if (e.
              getType(
                ).
              charAt(
                3) ==
              'p') {
            org.apache.batik.dom.events.DOMKeyEvent evt =
              (org.apache.batik.dom.events.DOMKeyEvent)
                e;
            matched =
              evt.
                getCharCode(
                  ) ==
                accesskey;
        }
        else {
            org.w3c.dom.events.KeyboardEvent evt =
              (org.w3c.dom.events.KeyboardEvent)
                e;
            matched =
              evt.
                getKeyIdentifier(
                  ).
                equals(
                  keyName);
        }
        if (matched) {
            owner.
              eventOccurred(
                this,
                e);
        }
    }
    public void resolve(org.w3c.dom.events.Event e) {
        float time =
          owner.
          getRoot(
            ).
          convertEpochTime(
            e.
              getTimeStamp(
                ));
        org.apache.batik.anim.timing.InstanceTime instance =
          new org.apache.batik.anim.timing.InstanceTime(
          this,
          time +
            offset,
          true);
        owner.
          addInstanceTime(
            instance,
            isBegin);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UrFDMUyD769IUiAbeNS1RDipt/D6cuUxwd6bdjJ5TMJrYolpG51iXBoRCnhW" +
       "uC21iXdx06Lx8Y5l/ZkyUBcCk+82zYKy6Ta+E4KVIAb9ea2lqmN23dGLuud0" +
       "JWpOx4txlCub9W618buIvNfxwXrltyc5jKpchE9pIhrtV6hu1izOUxbMtO3r" +
       "w2WvT9vUbtfeDWG8ThOCbIsrU01r9THe2I96hZ0vh/VdNMCTgtivJqt6QG1J" +
       "Rx3sGpkWsaYrEQiWxMJ4xeYB4+ftnPT9hhDDQzoci1m8YZL5sFPYC9ob5E02" +
       "cdVUQd0BW6caZkLWCWQq9x0UYMBWB4XxZJ41hbAt8NrQ5Eheb9A1l0IJzbBM" +
       "dZLWW23Er+t1Yc3PYD3qWGGoIqbNrluL3ZiNc7Gu7SeqJ46tUcPAs3GgeHtM" +
       "NhOULLI2TcfGqkYONhRN9Hi31UQJGOO6DbjdS1pdU15RizURhJ14iA8kxvIG" +
       "hrj2ZE1l4k6TdijfoWaG0MzyVkFbqTD17ZnQVpHmSk4sROtY1szpuFK4k7UJ" +
       "uk3HjbFmZYOQsHotrQ7SikAzStIaxDxu8OIYnRmwMvechRCudsoEw1NzO+g2" +
       "RXvdEanNoo11R5a60IvtTCewgOeG4YDrk2GX7A53mWwGOJpTddlDW3IyGFHe" +
       "MOhI24GGaqlRTzMVzs0Jxja2Od0JI7cxR6zNQqibRJ6MHDpmaBhjw4VNTMmh" +
       "0pDjgbkdJRLcl2xYJOAmrSUM6a8TfTyQnRousKrKKhQxk/0m2myTxnBfoCkt" +
       "eTixoG1Jsvq03HLrjXRGOHDeGC4bqar2cHNkch5jLcQZaWpGNNlqG28+Yqxl" +
       "QDR5xJpGiYTRm7WCKFuYybNlJCCt9nQrgdBELKdUc07rY3FDi2Qr0HSS7WuN" +
       "fguDUR3MqNXY0JFU2+1jciNFA28eLY2aEqW1oYHJIQ4XaL7l85RoOb15C0M7" +
       "Pr+iVLfX6gRJo7WAe4s6XkfnYl3MB5Q8Y+rwNpvi2VYp0GQtm0Pc9F2ZSHcY" +
       "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" +
       "MJL7bFH/i/u0/cuy+EQKPZyGhw3vyrDObOqTr2c7u6r4+Yu7+s+A5/3HvL3/" +
       "O8/bZ+7T9tmy+MW0vDvipNXNFfOum2FZ6BhnHP/St8vxc+BZH3O8/s5z/Fv3" +
       "afudsvj1FHrMMM94Luv+9Rl/v/Ht8lcGiZeO+XvpO8PflYsh5ql7hZgK+XP3" +
       "EcAXyuJ3U+gNKzUwPLNCusT/v/92+X8ePC8f8//yd5T/8vPzFcAf34fHPymL" +
       "L6bQ9fhwweoSf3/4ug6ggLDvdYejPJB+6o5rZIerT/qvvHrj4be+OvtP1TWG" +
       "0+tJj3DQw9bW886fzZx7vxbFpuVUTDxyOKmJqp8vp9Az9zu/TqFrh5eK/i8d" +
       "kP4shd58VyTg0eXPedj/nkI3L8Om0EPV73m4r4BgcQYHhj28nAf5ago9AEDK" +
       "1z+PTgz2/pdkjrPj2rwk4OLKuVx3bGuVCp/8Zio8RTl/d6LMj9XlwJNctj1c" +
       "D7ytf/bVgfDDX2/+wuHuhu6p+33Zy8McdP1wjeQ0H779nr2d9HWt98I3Hv/V" +
       "R951krsfPxB8ZvfnaHvb3S9KMH6UVlcb9r/x1n/73n/16peq04+/A3l5Tta1" +
       "KQAA");
}
