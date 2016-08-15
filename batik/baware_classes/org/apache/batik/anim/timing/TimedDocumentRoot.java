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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/Y2/4tuH/wP5bq0VPzMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "aYKRhySJ+ENvaNBjq9ovCxVSGaTxZiQ4Fa0qwmmYVgezyVDX6Q5L9xAMdl1O" +
       "wEyyT89NZ+a2NXHIWuut6AtzbVCNN67rDj0PqncGFUP34OVyhnaXujOW+hmO" +
       "dIbVWYNO2FjiO74oJV655SlUxI4YaYQagx5uj9SuM1K6206MtLei0N6uzG0v" +
       "QkmmJVODrbrAO0LANTcKjLYthmqNrSwTZYXtWUhlxYbejKzKXm3Wd9EVMZE1" +
       "JWHDNruOzFqZgRvbCjPwOZo1YnKELki8V+abiLPh8GGylDIOplHRQbQ0o1md" +
       "GjGeb+rr+hBrky5bnQeOSMN8uKzNBXEza6k+btFJtqarrXIm91dRNeu0DNXR" +
       "e2Z9kq01C5kiTtZv4K0gW1Nx3Nn6mDoZ8y1m26gu8ZXcNCZ82xhSznKzHfZ7" +
       "uLis9yVyxDSkutgYbdixxEzKbqNFTpEVQ3W3yKZd15iE6FuK1yFqdVQfTWaa" +
       "xEG8SeITZr3o9Zsdghux9XG1MxOhdZ2q4uTGjnt1ZexGcXkO1TAP3cBD05dt" +
       "d5nWPYVk6jNBqUHtcqI6wDR0wsnA4uPREMVCU1wg7WlXDOzAdwhWdquTIZgB" +
       "rY5Yw2vtZrSgOtWq41LMQtWnnDB2ibVmsD172GnVBQ9mghRqD2sbtyxRpGP4" +
       "eDrU5d6SDFCJQ9gRuhpTshoi3SxGVBZP/Grma051IPUC4EW5y6pnB2JCquV4" +
       "lYhVhFqK9qZqR1MI6bU6zeECqHipBtkhSmSCKWjdGkVMmjbX7Gx1q2GI9RHf" +
       "wKedMZesR1BkjxC1rk3ry95UpAN7hS0oahPZtXWyYk3FrW3QVtfaot627gnt" +
       "TlgzVolfgxox7U9pZbam1HCarPsZ1ALT24JMw2pOLWELD6cSbVXLiL7oevxK" +
       "GEEjNevXp2Yy1bQm5xlK0loN0HWZoZI+UemMkLKUITrWX2mUManpk07UKLer" +
       "KYPgjXbHUew4YSBALAEvnCkgh7ZFs67URSHtpRZDoBuedBRGq630PpWUJZ4h" +
       "6rAa13Ar45ahbFqhVm9tYQbqNGKF4LFqi+ptKFz2Y59BFsxiWSOaXprC4SSr" +
       "tiXWTyyHW5Uhd7U0cdUYA+2hsP4sYINZtaHXufYaWVeVqkihcreuc3F70U3J" +
       "YYvSnAViaFFDYVpOY7mh6Dq9pYn1CjUyG+frqh1U7cDJWvPWVg+kMhFMk3Ym" +
       "j6VWnPVgpZJxmi+iC3fcjyi6MyAUfCSjFOFrMGwRXLWqjGio0zVXod7t941x" +
       "Cxf1CrpigtGGMzrA7LezznS6Hq8rimYORhnFhUbQszRH4hrjbh2de5UZlU78" +
       "SpRE60qPS4at1cxiFsPetmkhk0ZNgDeTygBb4KvFauVmlLogGHczTSSed2wc" +
       "pxoQ26Xw1hClOlBtohJ6ay0lyjSZjWqQIsQeq5FcvdlbdhIuiJN4hallGdmG" +
       "Y53wp2mFkHEsape92DaYrd3pNZRZvG7KdtlDVoTsNjplGcLItqdkDarrCHPR" +
       "64uNuMp4XaY5qbQEPtJrRJjUSM+KeDnptTMpxnqM3JYbgSxUA0YyYq2mWzjr" +
       "JTTV08vkfOvSjq6z6tIxMIFcb6xKY0K5k0XYQgWxrUizpR9TMTpP16m+rKyR" +
       "kNyy6TCjVoY1niOBDXR9s49gGmssu7pGSxWqSq5xNujHyRh4NmU0CG2ujTb6" +
       "hrxVZ7OK1yh3U2EpTdTM1eSYnTEJP1q24dXGhjds4nFmo+MKqlUmZK3MpUHF" +
       "GXf4gYDxqriWLUMh2mkWmijPl/tLsVdrVkjZIhtda1rzcN8kBmOU6I6AuZi1" +
       "xIyhoOXEwfoiJ+g9ORD9kHZxs03bPanC+V0XLXeXKwyHaz0FMA83yhyOQcBB" +
       "0Rc2goiNjTposF4fFjaO6gEDbVFNj6iiUFsAFqyjTisyDzvyFirH7dYEl3mj" +
       "xlgqGzPLNOo0/H7aHkNmm6n7s2gTZxSt9bf1mO9Ps4UpJdNOXJ9vW/yM5RMY" +
       "eIupsmDGxhoI11StZGZYjiEEnm7R1C5vGHmwLa8heKN1VHi1jbIalQZUr2Mu" +
       "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" +
       "qNWvlmNBEbjWCi+ratKLwLpmQoynIjVh");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "p7g2+38B8xMqQSs+AAA=");
}
