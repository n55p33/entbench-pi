package org.apache.batik.anim.timing;
public abstract class TimedDocumentRoot extends org.apache.batik.anim.timing.TimeContainer {
    protected java.util.Calendar documentBeginTime;
    protected boolean useSVG11AccessKeys;
    protected boolean useSVG12AccessKeys;
    protected org.apache.batik.util.DoublyIndexedSet propagationFlags = new org.apache.batik.util.DoublyIndexedSet(
      );
    protected java.util.LinkedList listeners = new java.util.LinkedList(
      );
    protected boolean isSampling;
    protected boolean isHyperlinking;
    public TimedDocumentRoot(boolean useSVG11AccessKeys, boolean useSVG12AccessKeys) {
        super(
          );
        root =
          this;
        this.
          useSVG11AccessKeys =
          useSVG11AccessKeys;
        this.
          useSVG12AccessKeys =
          useSVG12AccessKeys;
    }
    protected float getImplicitDur() { return INDEFINITE;
    }
    public float getDefaultBegin(org.apache.batik.anim.timing.TimedElement child) {
        return 0.0F;
    }
    public float getCurrentTime() { return lastSampleTime;
    }
    public boolean isSampling() { return isSampling;
    }
    public boolean isHyperlinking() { return isHyperlinking;
    }
    public float seekTo(float time, boolean hyperlinking) {
        isSampling =
          true;
        lastSampleTime =
          time;
        isHyperlinking =
          hyperlinking;
        propagationFlags.
          clear(
            );
        float mint =
          java.lang.Float.
            POSITIVE_INFINITY;
        org.apache.batik.anim.timing.TimedElement[] es =
          getChildren(
            );
        for (int i =
               0;
             i <
               es.
                 length;
             i++) {
            float t =
              es[i].
              sampleAt(
                time,
                hyperlinking);
            if (t <
                  mint) {
                mint =
                  t;
            }
        }
        boolean needsUpdates;
        do  {
            needsUpdates =
              false;
            for (int i =
                   0;
                 i <
                   es.
                     length;
                 i++) {
                if (es[i].
                      shouldUpdateCurrentInterval) {
                    needsUpdates =
                      true;
                    float t =
                      es[i].
                      sampleAt(
                        time,
                        hyperlinking);
                    if (t <
                          mint) {
                        mint =
                          t;
                    }
                }
            }
        }while(needsUpdates); 
        isSampling =
          false;
        if (hyperlinking) {
            root.
              currentIntervalWillUpdate(
                );
        }
        return mint;
    }
    public void resetDocument(java.util.Calendar documentBeginTime) {
        if (documentBeginTime ==
              null) {
            this.
              documentBeginTime =
              java.util.Calendar.
                getInstance(
                  );
        }
        else {
            this.
              documentBeginTime =
              documentBeginTime;
        }
        reset(
          true);
    }
    public java.util.Calendar getDocumentBeginTime() {
        return documentBeginTime;
    }
    public float convertEpochTime(long t) { long begin =
                                              documentBeginTime.
                                              getTime(
                                                ).
                                              getTime(
                                                );
                                            return (t -
                                                      begin) /
                                              1000.0F;
    }
    public float convertWallclockTime(java.util.Calendar time) {
        long begin =
          documentBeginTime.
          getTime(
            ).
          getTime(
            );
        long t =
          time.
          getTime(
            ).
          getTime(
            );
        return (t -
                  begin) /
          1000.0F;
    }
    public void addTimegraphListener(org.apache.batik.anim.timing.TimegraphListener l) {
        listeners.
          add(
            l);
    }
    public void removeTimegraphListener(org.apache.batik.anim.timing.TimegraphListener l) {
        listeners.
          remove(
            l);
    }
    void fireElementAdded(org.apache.batik.anim.timing.TimedElement e) {
        java.util.Iterator i =
          listeners.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            ((org.apache.batik.anim.timing.TimegraphListener)
               i.
               next(
                 )).
              elementAdded(
                e);
        }
    }
    void fireElementRemoved(org.apache.batik.anim.timing.TimedElement e) {
        java.util.Iterator i =
          listeners.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            ((org.apache.batik.anim.timing.TimegraphListener)
               i.
               next(
                 )).
              elementRemoved(
                e);
        }
    }
    boolean shouldPropagate(org.apache.batik.anim.timing.Interval i,
                            org.apache.batik.anim.timing.TimingSpecifier ts,
                            boolean isBegin) {
        org.apache.batik.anim.timing.InstanceTime it =
          isBegin
          ? i.
          getBeginInstanceTime(
            )
          : i.
          getEndInstanceTime(
            );
        if (propagationFlags.
              contains(
                it,
                ts)) {
            return false;
        }
        propagationFlags.
          add(
            it,
            ts);
        return true;
    }
    protected void currentIntervalWillUpdate() {
        
    }
    protected abstract java.lang.String getEventNamespaceURI(java.lang.String eventName);
    protected abstract java.lang.String getEventType(java.lang.String eventName);
    protected abstract java.lang.String getRepeatEventName();
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ae5AUxRnv3TuO4zi4F+/344DwuhVUlBwR4e6A0wUud4CV" +
       "QzjmZnv3hpudGWd6jwUh8VEGkpSUQXxRwh8JBh8oxvIZo2L5QOMjPkOMUYym" +
       "KqihlLI0KSUx39czszM7uzNXa7G5qumd6+6v+/t+/b26pw+fIgMMnUygCmtg" +
       "WzVqNLQorE3QDRprkgXDWAN1XeItJcIXG0+uWhgmZZ1kaI9grBQFgy6TqBwz" +
       "Osl4STGYoIjUWEVpDCnadGpQvU9gkqp0kuGS0ZrUZEmU2Eo1RrHDOkGPkhqB" +
       "MV3qTjHaag3AyPgocBLhnESWeJsbo6RSVLWtTvdRru5NrhbsmXTmMhipjm4W" +
       "+oRIiklyJCoZrDGtk9maKm9NyCproGnWsFk+34Lgkuj5ORBMub/qq29u6Knm" +
       "ENQJiqIyLp7RTg1V7qOxKKlyaltkmjSuID8mJVEy2NWZkfqoPWkEJo3ApLa0" +
       "Ti/gfghVUskmlYvD7JHKNBEZYmRy9iCaoAtJa5g2zjOMUM4s2TkxSDspI60p" +
       "ZY6IN82O7L1lY/UDJaSqk1RJSgeyIwITDCbpBEBpspvqxpJYjMY6SY0Ci91B" +
       "dUmQpW3WStcaUkIRWAqW34YFK1Ma1fmcDlawjiCbnhKZqmfEi3OFsv4bEJeF" +
       "BMg6wpHVlHAZ1oOAFRIwpscF0DuLpLRXUmKMTPRSZGSsvxQ6AOnAJGU9amaq" +
       "UkWAClJrqogsKIlIB6iekoCuA1RQQJ2RMb6DItaaIPYKCdqFGunp12Y2Qa9B" +
       "HAgkYWS4txsfCVZpjGeVXOtzatWi3VcqK5QwCQHPMSrKyP9gIJrgIWqncapT" +
       "sAOTsHJW9GZhxBO7woRA5+GezmafR7afvnjOhKMvmH3G5umzunszFVmXeLB7" +
       "6OvjmmYuLEE2yjXVkHDxsyTnVtZmtTSmNfAwIzIjYmOD3Xi0/fkfXXU3/TRM" +
       "KlpJmajKqSToUY2oJjVJpvpyqlBdYDTWSgZRJdbE21vJQHiPSgo1a1fH4wZl" +
       "raRU5lVlKv8fIIrDEAhRBbxLSly13zWB9fD3tEYIqYaHDIdnCjH/+C8jQqRH" +
       "TdKIIAqKpKiRNl1F+Y0IeJxuwLYn0g1a3xsx1JQOKhhR9UREAD3ooVYDkIFR" +
       "SknQo8gaKUljzaqYSgJ1uwoooKpp/49J0ihp3ZZQCBZhnNcFyGA9K1Q5RvUu" +
       "cW9qacvp+7peMtULTcLCiJEGmLfBnLeBz9uA8zaY8zbkzEtCIT7dMJzfXG9Y" +
       "rV6we3C8lTM7NlyyadeUElA0bUspQI1dp2QFoCbHOdgevUs8Ujtk2+T35z0T" +
       "JqVRUiuILCXIGE+W6AnwVGKvZcyV3RCanAgxyRUhMLTpqkhj4KD8IoU1Srna" +
       "R3WsZ2SYawQ7fqGlRvyjR17+ydFbt1y97ifnhEk4OyjglAPAnyF5G7ryjMuu" +
       "9zqDfONW7Tz51ZGbd6iOW8iKMnZwzKFEGaZ4FcILT5c4a5LwUNcTO+o57IPA" +
       "bTMBzAw84gTvHFlep9H24ChLOQgcV/WkIGOTjXEF69HVLU4N19Qa/j4M1GIw" +
       "muE4eNotu+S/2DpCw3KkqdmoZx4peIT4QYe2/8+vfnwuh9sOJlWuLKCDskaX" +
       "A8PBarmrqnHUdo1OKfR779a2G286tXM911noMTXfhPVYNoHjgiUEmK974Yp3" +
       "Trx/8K2wo+cMIniqGxKhdEZIrCcVAULCbNMdfsAByuAfUGvq1yqgn1JcErpl" +
       "ioZ1pmravIf+ubva1AMZamw1mtP/AE796KXkqpc2/msCHyYkYgB2MHO6mV69" +
       "zhl5ia4LW5GP9NVvjL/tmLAf4gP4ZEPaRrmbDXMMwtm2jvbUkeo2wC7BlzCp" +
       "z4pY89s2ibvq2/5uRqPReQjMfsPvjFy/7vjml/kil6PlYz3KPcRl1+AhXBpW" +
       "bYL/LfyF4PkvPgg6Vpiev7bJCj+TMvFH09LA+cyAhDFbgMiO2hO9t5+81xTA" +
       "G589nemuvT//tmH3XnPlzCRmak4e4aYxExlTHCwWIneTg2bhFMv+cWTH43fu" +
       "2GlyVZsdklsg47z3T/95ueHWD17MEwMGdquqTAXTXZ2H6pxx3sOy18cUqvln" +
       "Vb+/obZkGfiNVlKeUqQrUrQ15h4V8jAj1e1aMCdB4hVu8XBxIK7MgnXAigt5" +
       "eT7n5ZwMR4RzRHjbCiymGW4fmr1mrny7S7zhrc+HrPv8ydNc7uyE3e0yVgqa" +
       "CXoNFtMR9JHeGLdCMHqg33lHV11eLR/9BkbshBFFiN7Gah0CbTrLwVi9Bwz8" +
       "y9PPjNj0egkJLyMVsirElgncV5NB4CSp0QMxOq0tvtj0EVvK7bQlTXKEz6lA" +
       "O52Y3wO0JDXGbXbboyMfXHTowPvcWWnmGGM5/UBMG7KCM9/2OfHh7jcvePvQ" +
       "L2/eYupUgIV46EZ9vVruvubDf+dAzsNhHqPx0HdGDt8+pumiTzm9E5eQuj6d" +
       "m+pAbHdo59+d/DI8pey5MBnYSapFa5u1TpBT6O07YWth2Hsv2IpltWdvE8yc" +
       "uDETd8d5rdY1rTciug2hlGUpvRMEh+ISzoRnhhUfZniDYIjwl05OMoOXs7CY" +
       "a8ecQZquMuCSxjxhZ0jAsIzUxKyMbilNSArmeJx6FADgUiZBhgRc0M1IjGUr" +
       "FuvNmaK+CrsmV8C5FidzfQQ0p5+BxYZcOfyogduUQTvWLZ83bwm3wUvpVk59" +
       "oYfl+Hdg+Vxr0nN9WJYDWfajdlieH8xyskCWW+FZaE260IdlI5BlP2pGqkHJ" +
       "NCHBLZhnQ7ayTM/ZOnDFaVYhEdraqsRoGk8RmEc0VqBoC+BZbDG32Ee07YGi" +
       "+VGD/WAqhXmAAa5wfJ5UpF3YwnfpXeLlM6pH1C/8YooV9fP0dW3ndz/+u87O" +
       "GdWi2TlfUuTZxt95qFx8N/k8T4qQtwuyMRgFz4uWFPyXkcvP9u4Sz7WQUWv3" +
       "WtTxeXTNijwO0Pf0yks+u/A3PzCxm+wTdJz+j/3wg9f3bzty2MxrME9kZLbf" +
       "SVzu8R9ulaYFbPecRf1y+fePfvzRug32Gg3F4rq0bQ15d8TYdr03rcJ/W9Ie" +
       "s9hRoFlMhqfZUolmH7PYE2gWftQMY2SHgMe6SiKfc7qxQFanWQ7KdlT5WL0t" +
       "kFU/akaGSsYKWB0deO31YXdfALvp/KE1jK8NjJQLYKo6pGtOeOV/VcRzpOTi" +
       "yZVgEdTz8X6nfjxtP3jN3gOx1XfMs5XqYnBKTNXmyrSPyq6h6rIdFFjMSn7O" +
       "6SQ+7w3d89Fj9YmlhZyhYN2Efk5J8P+JYCSz/I3Ey8qxaz4Zs+aink0FHIdM" +
       "9KDkHfKulYdfXD5d3BPmh7pmRpZzGJxN1Jidh1XolKV0JXsLMjWzrsPstdxg" +
       "resGr6Y6auWnpn6kAXuZBwLaHsTiXtDxBGX2V5bmlLlCC7BYaKplo+t9McNM" +
       "VBVYfqfjWMV9/Rlx8MYDK9o1Xn9XBogabJsET8ICItEPhrNzD0v8SD042TtU" +
       "y/nO7P8U04o/nIVnA1B/AYunYHMIqDfTuJCSzTQZqx928DtaLPwmwqNYICiF" +
       "4+dHGiDxmwFtb2PxqqmDTSkdUhaGaHrA+GMRwKjDtvHwpCyJUoWD4UcaIPAH" +
       "AW0fYvFubnx0gPhrsYDAcL/dkmZ74UD4kQYIeyqg7TMsTuaPvg4YHxfLREbC" +
       "c60l0bWFg+FH6hE47KQCD3PJ+NBfB8ByBosvGSkzKO1do3qM5KsiwMEP0nHL" +
       "dtiS6XDhcPiR5ve4+C//8BQa6I9EaBAWYUaG4G0BZn9AyhetSvtUKZYBKVRS" +
       "BJB4aP8ePI9akj5aOEh+pAEYBLWNxqIWNg0JB53MYQyH2IGkrlhmhD7lKUuu" +
       "pwqHxI80IFIHZC2lsqok8ictHLH6ADRnYzGR8eM+yFpZi6aKPblhKjSpWEji" +
       "DueYBcexwpH0I+3PAhcEYIK7oNA80DALk8sEWRZlVezNg8v8Ynqm1yzhXisc" +
       "Fz/S4Fyw/y/aCV3QeqLW0Q9HqykAyeVYXARICrFYDjW2DXaQXFwsJBfBc9yC" +
       "43jhSPqR+mpYqJnL3h6AyxosVjIyUqdJ2Cz2B82qIkDD2/C49oQl34kAaHjp" +
       "2uQTz5l5acA4/pb4HMdiUwBO3Vh0gneKSzq1diH8opUHoH5P1r8rQLPh+cQS" +
       "7JNg3QltyMXEj7Q/TJIBmGBuFOphpNaFSTtXIy8qUhFQqcS2sfCcsUQ7Uzgq" +
       "fqQeoUs4IyW2b5oW6Jta8dZbnyDbvef058ngp0OjohSXzK9jPEUNbQsA/ios" +
       "UrC7NXrUlBxrs472eURwUvdQXxFQ52eBDaAileaY5m+AH8s9YfElDZD4FwFt" +
       "12PxU0ZGi+bW1l6AyyRZXqvFTFzc2rizCLhMwLb5IFSdJVxdAC5eJ8a3Jxux" +
       "+JXHnY0IGDE4gFbzk2z8CNpg3pXkWN0WgON+LG4009mWPgBylZCkBiguXdvO" +
       "cdvnQLi3WBDOAhFGWwKPPmsQ+o3oHzn3cUjuCoDrHix+zUilDZd1KOmG6WCx" +
       "YDoH2JxoCTXxrMHkN2IACo8EtD2GxW8hPgBC7VSjgqNWHpweOBs4pRmpybnq" +
       "iJcrRuVcrDYvA4v3HagqH3lg7XF+2p65sFsZJeXxlCy7P/+73ss0ncYlDnKl" +
       "eRmAX3kJPc3IuCBXz0iZ+YL8h46aRM8yMjwvEeyl8Mfd9xgYtbcvIwP4r7vf" +
       "HxipcPrBtOaLu8srjJRAF3x9VbM9xqx+U+4m+xJH2nQzY90rwo9Hhve3kK5v" +
       "KlOzvkXwO/L2d4NUm/Vd8MiBS1ZdeXrBHeYlQVEWtm3DUQZHyUDzviIftCTn" +
       "G6N7NHusshUzvxl6/6Bp9leaGpNhx1rGOrqL1/xCGirPGM8NOqM+c5HunYOL" +
       "nnxlV9kbYRJaT0ICI3Xrc6+epLWUTsavj+ZewVon6PxqX+PMfVsvmhP/7F1+" +
       "uYeYV7bG+ffvEt86tOHNPaMOTgiTwa1kgIQf6fmdmOatSjsV+/ROMkQyWtI8" +
       "hWeSIGfd7xqKei5gROC4WHAOydTiFVNGpuReb8u9mFshq1uovlRNKZjw4Q2x" +
       "wU6NuTKezzcpTfMQODXWUmLZjMXCNK4GaGpXdKWm2bf/yDCN23tLvpyVf5AN" +
       "/Y2/4tuH/wPhvBZJPzMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UC3HgiJw7RVWVtWkH4F1zQQfT0VqwmgG");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "s/8XpxZ4UCs+AAA=");
}
