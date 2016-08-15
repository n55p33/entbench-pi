package org.apache.batik.anim.timing;
public abstract class TimedElement implements org.apache.batik.util.SMILConstants {
    public static final int FILL_REMOVE = 0;
    public static final int FILL_FREEZE = 1;
    public static final int RESTART_ALWAYS = 0;
    public static final int RESTART_WHEN_NOT_ACTIVE = 1;
    public static final int RESTART_NEVER = 2;
    public static final float INDEFINITE = java.lang.Float.POSITIVE_INFINITY;
    public static final float UNRESOLVED = java.lang.Float.NaN;
    protected org.apache.batik.anim.timing.TimedDocumentRoot root;
    protected org.apache.batik.anim.timing.TimeContainer parent;
    protected org.apache.batik.anim.timing.TimingSpecifier[] beginTimes;
    protected org.apache.batik.anim.timing.TimingSpecifier[] endTimes;
    protected float simpleDur;
    protected boolean durMedia;
    protected float repeatCount;
    protected float repeatDur;
    protected int currentRepeatIteration;
    protected float lastRepeatTime;
    protected int fillMode;
    protected int restartMode;
    protected float min;
    protected boolean minMedia;
    protected float max;
    protected boolean maxMedia;
    protected boolean isActive;
    protected boolean isFrozen;
    protected float lastSampleTime;
    protected float repeatDuration;
    protected java.util.List beginInstanceTimes = new java.util.ArrayList(
      );
    protected java.util.List endInstanceTimes = new java.util.ArrayList();
    protected org.apache.batik.anim.timing.Interval currentInterval;
    protected float lastIntervalEnd;
    protected org.apache.batik.anim.timing.Interval previousInterval;
    protected java.util.LinkedList beginDependents = new java.util.LinkedList(
      );
    protected java.util.LinkedList endDependents = new java.util.LinkedList(
      );
    protected boolean shouldUpdateCurrentInterval = true;
    protected boolean hasParsed;
    protected java.util.Map handledEvents = new java.util.HashMap();
    protected boolean isSampling;
    protected boolean hasPropagated;
    public TimedElement() { super();
                            beginTimes = (new org.apache.batik.anim.timing.TimingSpecifier[0]);
                            endTimes = beginTimes;
                            simpleDur = UNRESOLVED;
                            repeatCount = UNRESOLVED;
                            repeatDur = UNRESOLVED;
                            lastRepeatTime = UNRESOLVED;
                            max = INDEFINITE;
                            lastSampleTime = UNRESOLVED;
                            lastIntervalEnd = java.lang.Float.NEGATIVE_INFINITY;
    }
    public org.apache.batik.anim.timing.TimedDocumentRoot getRoot() { return root;
    }
    public float getActiveTime() { return lastSampleTime; }
    public float getSimpleTime() { return lastSampleTime - lastRepeatTime;
    }
    protected float addInstanceTime(org.apache.batik.anim.timing.InstanceTime time,
                                    boolean isBegin) { hasPropagated =
                                                         true;
                                                       java.util.List instanceTimes =
                                                         isBegin
                                                         ? beginInstanceTimes
                                                         : endInstanceTimes;
                                                       int index =
                                                         java.util.Collections.
                                                         binarySearch(
                                                           instanceTimes,
                                                           time);
                                                       if (index <
                                                             0) {
                                                           index =
                                                             -(index +
                                                                 1);
                                                       }
                                                       instanceTimes.
                                                         add(
                                                           index,
                                                           time);
                                                       shouldUpdateCurrentInterval =
                                                         true;
                                                       float ret;
                                                       if (root.
                                                             isSampling(
                                                               ) &&
                                                             !isSampling) {
                                                           ret =
                                                             sampleAt(
                                                               root.
                                                                 getCurrentTime(
                                                                   ),
                                                               root.
                                                                 isHyperlinking(
                                                                   ));
                                                       }
                                                       else {
                                                           ret =
                                                             java.lang.Float.
                                                               POSITIVE_INFINITY;
                                                       }
                                                       hasPropagated =
                                                         false;
                                                       root.
                                                         currentIntervalWillUpdate(
                                                           );
                                                       return ret;
    }
    protected float removeInstanceTime(org.apache.batik.anim.timing.InstanceTime time,
                                       boolean isBegin) {
        hasPropagated =
          true;
        java.util.List instanceTimes =
          isBegin
          ? beginInstanceTimes
          : endInstanceTimes;
        int index =
          java.util.Collections.
          binarySearch(
            instanceTimes,
            time);
        for (int i =
               index;
             i >=
               0;
             i--) {
            org.apache.batik.anim.timing.InstanceTime it =
              (org.apache.batik.anim.timing.InstanceTime)
                instanceTimes.
                get(
                  i);
            if (it ==
                  time) {
                instanceTimes.
                  remove(
                    i);
                break;
            }
            if (it.
                  compareTo(
                    time) !=
                  0) {
                break;
            }
        }
        int len =
          instanceTimes.
          size(
            );
        for (int i =
               index +
               1;
             i <
               len;
             i++) {
            org.apache.batik.anim.timing.InstanceTime it =
              (org.apache.batik.anim.timing.InstanceTime)
                instanceTimes.
                get(
                  i);
            if (it ==
                  time) {
                instanceTimes.
                  remove(
                    i);
                break;
            }
            if (it.
                  compareTo(
                    time) !=
                  0) {
                break;
            }
        }
        shouldUpdateCurrentInterval =
          true;
        float ret;
        if (root.
              isSampling(
                ) &&
              !isSampling) {
            ret =
              sampleAt(
                root.
                  getCurrentTime(
                    ),
                root.
                  isHyperlinking(
                    ));
        }
        else {
            ret =
              java.lang.Float.
                POSITIVE_INFINITY;
        }
        hasPropagated =
          false;
        root.
          currentIntervalWillUpdate(
            );
        return ret;
    }
    protected float instanceTimeChanged(org.apache.batik.anim.timing.InstanceTime time,
                                        boolean isBegin) {
        hasPropagated =
          true;
        shouldUpdateCurrentInterval =
          true;
        float ret;
        if (root.
              isSampling(
                ) &&
              !isSampling) {
            ret =
              sampleAt(
                root.
                  getCurrentTime(
                    ),
                root.
                  isHyperlinking(
                    ));
        }
        else {
            ret =
              java.lang.Float.
                POSITIVE_INFINITY;
        }
        hasPropagated =
          false;
        return ret;
    }
    protected void addDependent(org.apache.batik.anim.timing.TimingSpecifier dependent,
                                boolean forBegin) {
        if (forBegin) {
            beginDependents.
              add(
                dependent);
        }
        else {
            endDependents.
              add(
                dependent);
        }
    }
    protected void removeDependent(org.apache.batik.anim.timing.TimingSpecifier dependent,
                                   boolean forBegin) {
        if (forBegin) {
            beginDependents.
              remove(
                dependent);
        }
        else {
            endDependents.
              remove(
                dependent);
        }
    }
    public float getSimpleDur() { if (durMedia) {
                                      return getImplicitDur(
                                               );
                                  }
                                  else
                                      if (isUnresolved(
                                            simpleDur)) {
                                          if (isUnresolved(
                                                repeatCount) &&
                                                isUnresolved(
                                                  repeatDur) &&
                                                endTimes.
                                                  length >
                                                0) {
                                              return INDEFINITE;
                                          }
                                          return getImplicitDur(
                                                   );
                                      }
                                      else {
                                          return simpleDur;
                                      } }
    public static boolean isUnresolved(float t) {
        return java.lang.Float.
          isNaN(
            t);
    }
    public float getActiveDur(float B, float end) {
        float d =
          getSimpleDur(
            );
        float PAD;
        if (!isUnresolved(
               end) &&
              d ==
              INDEFINITE) {
            PAD =
              minusTime(
                end,
                B);
            repeatDuration =
              minTime(
                max,
                maxTime(
                  min,
                  PAD));
            return repeatDuration;
        }
        float IAD;
        if (d ==
              0) {
            IAD =
              0;
        }
        else {
            if (isUnresolved(
                  repeatDur) &&
                  isUnresolved(
                    repeatCount)) {
                IAD =
                  d;
            }
            else {
                float p1 =
                  isUnresolved(
                    repeatCount)
                  ? INDEFINITE
                  : multiplyTime(
                      d,
                      repeatCount);
                float p2 =
                  isUnresolved(
                    repeatDur)
                  ? INDEFINITE
                  : repeatDur;
                IAD =
                  minTime(
                    minTime(
                      p1,
                      p2),
                    INDEFINITE);
            }
        }
        if (isUnresolved(
              end) ||
              end ==
              INDEFINITE) {
            PAD =
              IAD;
        }
        else {
            PAD =
              minTime(
                IAD,
                minusTime(
                  end,
                  B));
        }
        repeatDuration =
          IAD;
        return minTime(
                 max,
                 maxTime(
                   min,
                   PAD));
    }
    protected float minusTime(float t1, float t2) {
        if (isUnresolved(
              t1) ||
              isUnresolved(
                t2)) {
            return UNRESOLVED;
        }
        if (t1 ==
              INDEFINITE ||
              t2 ==
              INDEFINITE) {
            return INDEFINITE;
        }
        return t1 -
          t2;
    }
    protected float multiplyTime(float t,
                                 float n) {
        if (isUnresolved(
              t) ||
              t ==
              INDEFINITE) {
            return t;
        }
        return t *
          n;
    }
    protected float minTime(float t1, float t2) {
        if (t1 ==
              0.0F ||
              t2 ==
              0.0F) {
            return 0.0F;
        }
        if ((t1 ==
               INDEFINITE ||
               isUnresolved(
                 t1)) &&
              t2 !=
              INDEFINITE &&
              !isUnresolved(
                 t2)) {
            return t2;
        }
        if ((t2 ==
               INDEFINITE ||
               isUnresolved(
                 t2)) &&
              t1 !=
              INDEFINITE &&
              !isUnresolved(
                 t1)) {
            return t1;
        }
        if (t1 ==
              INDEFINITE &&
              isUnresolved(
                t2) ||
              isUnresolved(
                t1) &&
              t2 ==
              INDEFINITE) {
            return INDEFINITE;
        }
        if (t1 <
              t2) {
            return t1;
        }
        return t2;
    }
    protected float maxTime(float t1, float t2) {
        if ((t1 ==
               INDEFINITE ||
               isUnresolved(
                 t1)) &&
              t2 !=
              INDEFINITE &&
              !isUnresolved(
                 t2)) {
            return t1;
        }
        if ((t2 ==
               INDEFINITE ||
               isUnresolved(
                 t2)) &&
              t1 !=
              INDEFINITE &&
              !isUnresolved(
                 t1)) {
            return t2;
        }
        if (t1 ==
              INDEFINITE &&
              isUnresolved(
                t2) ||
              isUnresolved(
                t1) &&
              t2 ==
              INDEFINITE) {
            return UNRESOLVED;
        }
        if (t1 >
              t2) {
            return t1;
        }
        return t2;
    }
    protected float getImplicitDur() { return UNRESOLVED;
    }
    protected float notifyNewInterval(org.apache.batik.anim.timing.Interval interval) {
        float dependentMinTime =
          java.lang.Float.
            POSITIVE_INFINITY;
        java.util.Iterator i =
          beginDependents.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.TimingSpecifier ts =
              (org.apache.batik.anim.timing.TimingSpecifier)
                i.
                next(
                  );
            float t =
              ts.
              newInterval(
                interval);
            if (t <
                  dependentMinTime) {
                dependentMinTime =
                  t;
            }
        }
        i =
          endDependents.
            iterator(
              );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.TimingSpecifier ts =
              (org.apache.batik.anim.timing.TimingSpecifier)
                i.
                next(
                  );
            float t =
              ts.
              newInterval(
                interval);
            if (t <
                  dependentMinTime) {
                dependentMinTime =
                  t;
            }
        }
        return dependentMinTime;
    }
    protected float notifyRemoveInterval(org.apache.batik.anim.timing.Interval interval) {
        float dependentMinTime =
          java.lang.Float.
            POSITIVE_INFINITY;
        java.util.Iterator i =
          beginDependents.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.TimingSpecifier ts =
              (org.apache.batik.anim.timing.TimingSpecifier)
                i.
                next(
                  );
            float t =
              ts.
              removeInterval(
                interval);
            if (t <
                  dependentMinTime) {
                dependentMinTime =
                  t;
            }
        }
        i =
          endDependents.
            iterator(
              );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.TimingSpecifier ts =
              (org.apache.batik.anim.timing.TimingSpecifier)
                i.
                next(
                  );
            float t =
              ts.
              removeInterval(
                interval);
            if (t <
                  dependentMinTime) {
                dependentMinTime =
                  t;
            }
        }
        return dependentMinTime;
    }
    protected float sampleAt(float parentSimpleTime,
                             boolean hyperlinking) {
        isSampling =
          true;
        float time =
          parentSimpleTime;
        java.util.Iterator i =
          handledEvents.
          entrySet(
            ).
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            java.util.Map.Entry e =
              (java.util.Map.Entry)
                i.
                next(
                  );
            org.w3c.dom.events.Event evt =
              (org.w3c.dom.events.Event)
                e.
                getKey(
                  );
            java.util.Set ts =
              (java.util.Set)
                e.
                getValue(
                  );
            java.util.Iterator j =
              ts.
              iterator(
                );
            boolean hasBegin =
              false;
            boolean hasEnd =
              false;
            while (j.
                     hasNext(
                       ) &&
                     !(hasBegin &&
                         hasEnd)) {
                org.apache.batik.anim.timing.EventLikeTimingSpecifier t =
                  (org.apache.batik.anim.timing.EventLikeTimingSpecifier)
                    j.
                    next(
                      );
                if (t.
                      isBegin(
                        )) {
                    hasBegin =
                      true;
                }
                else {
                    hasEnd =
                      true;
                }
            }
            boolean useBegin;
            boolean useEnd;
            if (hasBegin &&
                  hasEnd) {
                useBegin =
                  !isActive ||
                    restartMode ==
                    RESTART_ALWAYS;
                useEnd =
                  !useBegin;
            }
            else
                if (hasBegin &&
                      (!isActive ||
                         restartMode ==
                         RESTART_ALWAYS)) {
                    useBegin =
                      true;
                    useEnd =
                      false;
                }
                else
                    if (hasEnd &&
                          isActive) {
                        useBegin =
                          false;
                        useEnd =
                          true;
                    }
                    else {
                        continue;
                    }
            j =
              ts.
                iterator(
                  );
            while (j.
                     hasNext(
                       )) {
                org.apache.batik.anim.timing.EventLikeTimingSpecifier t =
                  (org.apache.batik.anim.timing.EventLikeTimingSpecifier)
                    j.
                    next(
                      );
                boolean isBegin =
                  t.
                  isBegin(
                    );
                if (isBegin &&
                      useBegin ||
                      !isBegin &&
                      useEnd) {
                    t.
                      resolve(
                        evt);
                    shouldUpdateCurrentInterval =
                      true;
                }
            }
        }
        handledEvents.
          clear(
            );
        if (currentInterval !=
              null) {
            float begin =
              currentInterval.
              getBegin(
                );
            if (lastSampleTime <
                  begin &&
                  time >=
                  begin) {
                if (!isActive) {
                    toActive(
                      begin);
                }
                isActive =
                  true;
                isFrozen =
                  false;
                lastRepeatTime =
                  begin;
                fireTimeEvent(
                  SMIL_BEGIN_EVENT_NAME,
                  currentInterval.
                    getBegin(
                      ),
                  0);
            }
        }
        boolean hasEnded =
          currentInterval !=
          null &&
          time >=
          currentInterval.
          getEnd(
            );
        if (currentInterval !=
              null) {
            float begin =
              currentInterval.
              getBegin(
                );
            if (time >=
                  begin) {
                float d =
                  getSimpleDur(
                    );
                while (time -
                         lastRepeatTime >=
                         d &&
                         lastRepeatTime +
                         d <
                         begin +
                         repeatDuration) {
                    lastRepeatTime +=
                      d;
                    currentRepeatIteration++;
                    fireTimeEvent(
                      root.
                        getRepeatEventName(
                          ),
                      lastRepeatTime,
                      currentRepeatIteration);
                }
            }
        }
        float dependentMinTime =
          java.lang.Float.
            POSITIVE_INFINITY;
        if (hyperlinking) {
            shouldUpdateCurrentInterval =
              true;
        }
        while (shouldUpdateCurrentInterval ||
                 hasEnded) {
            if (hasEnded) {
                previousInterval =
                  currentInterval;
                isActive =
                  false;
                isFrozen =
                  fillMode ==
                    FILL_FREEZE;
                toInactive(
                  false,
                  isFrozen);
                fireTimeEvent(
                  SMIL_END_EVENT_NAME,
                  currentInterval.
                    getEnd(
                      ),
                  0);
            }
            boolean first =
              currentInterval ==
              null &&
              previousInterval ==
              null;
            if (currentInterval !=
                  null &&
                  hyperlinking) {
                isActive =
                  false;
                isFrozen =
                  false;
                toInactive(
                  false,
                  false);
                currentInterval =
                  null;
            }
            if (currentInterval ==
                  null ||
                  hasEnded) {
                if (first ||
                      hyperlinking ||
                      restartMode !=
                      RESTART_NEVER) {
                    float beginAfter;
                    boolean incl =
                      true;
                    if (first ||
                          hyperlinking) {
                        beginAfter =
                          java.lang.Float.
                            NEGATIVE_INFINITY;
                    }
                    else {
                        beginAfter =
                          previousInterval.
                            getEnd(
                              );
                        incl =
                          beginAfter !=
                            previousInterval.
                            getBegin(
                              );
                    }
                    org.apache.batik.anim.timing.Interval interval =
                      computeInterval(
                        first,
                        false,
                        beginAfter,
                        incl);
                    if (interval ==
                          null) {
                        currentInterval =
                          null;
                    }
                    else {
                        float dmt =
                          selectNewInterval(
                            time,
                            interval);
                        if (dmt <
                              dependentMinTime) {
                            dependentMinTime =
                              dmt;
                        }
                    }
                }
                else {
                    currentInterval =
                      null;
                }
            }
            else {
                float currentBegin =
                  currentInterval.
                  getBegin(
                    );
                if (currentBegin >
                      time) {
                    float beginAfter;
                    boolean incl =
                      true;
                    if (previousInterval ==
                          null) {
                        beginAfter =
                          java.lang.Float.
                            NEGATIVE_INFINITY;
                    }
                    else {
                        beginAfter =
                          previousInterval.
                            getEnd(
                              );
                        incl =
                          beginAfter !=
                            previousInterval.
                            getBegin(
                              );
                    }
                    org.apache.batik.anim.timing.Interval interval =
                      computeInterval(
                        false,
                        false,
                        beginAfter,
                        incl);
                    float dmt =
                      notifyRemoveInterval(
                        currentInterval);
                    if (dmt <
                          dependentMinTime) {
                        dependentMinTime =
                          dmt;
                    }
                    if (interval ==
                          null) {
                        currentInterval =
                          null;
                    }
                    else {
                        dmt =
                          selectNewInterval(
                            time,
                            interval);
                        if (dmt <
                              dependentMinTime) {
                            dependentMinTime =
                              dmt;
                        }
                    }
                }
                else {
                    org.apache.batik.anim.timing.Interval interval =
                      computeInterval(
                        false,
                        true,
                        currentBegin,
                        true);
                    float newEnd =
                      interval.
                      getEnd(
                        );
                    if (currentInterval.
                          getEnd(
                            ) !=
                          newEnd) {
                        float dmt =
                          currentInterval.
                          setEnd(
                            newEnd,
                            interval.
                              getEndInstanceTime(
                                ));
                        if (dmt <
                              dependentMinTime) {
                            dependentMinTime =
                              dmt;
                        }
                    }
                }
            }
            shouldUpdateCurrentInterval =
              false;
            hyperlinking =
              false;
            hasEnded =
              currentInterval !=
                null &&
                time >=
                currentInterval.
                getEnd(
                  );
        }
        float d =
          getSimpleDur(
            );
        if (isActive &&
              !isFrozen) {
            if (time -
                  currentInterval.
                  getBegin(
                    ) >=
                  repeatDuration) {
                isFrozen =
                  fillMode ==
                    FILL_FREEZE;
                toInactive(
                  true,
                  isFrozen);
            }
            else {
                sampledAt(
                  time -
                    lastRepeatTime,
                  d,
                  currentRepeatIteration);
            }
        }
        if (isFrozen) {
            float t;
            boolean atLast;
            if (isActive) {
                t =
                  currentInterval.
                    getBegin(
                      ) +
                    repeatDuration -
                    lastRepeatTime;
                atLast =
                  lastRepeatTime +
                    d ==
                    currentInterval.
                    getBegin(
                      ) +
                    repeatDuration;
            }
            else {
                t =
                  previousInterval.
                    getEnd(
                      ) -
                    lastRepeatTime;
                atLast =
                  lastRepeatTime +
                    d ==
                    previousInterval.
                    getEnd(
                      );
            }
            if (atLast) {
                sampledLastValue(
                  currentRepeatIteration);
            }
            else {
                sampledAt(
                  t %
                    d,
                  d,
                  currentRepeatIteration);
            }
        }
        else
            if (!isActive) {
                
            }
        isSampling =
          false;
        lastSampleTime =
          time;
        if (currentInterval !=
              null) {
            float t =
              currentInterval.
              getBegin(
                ) -
              time;
            if (t <=
                  0) {
                t =
                  isConstantAnimation(
                    ) ||
                    isFrozen
                    ? currentInterval.
                    getEnd(
                      ) -
                    time
                    : 0;
            }
            if (dependentMinTime <
                  t) {
                return dependentMinTime;
            }
            return t;
        }
        return dependentMinTime;
    }
    protected boolean endHasEventConditions() {
        for (int i =
               0;
             i <
               endTimes.
                 length;
             i++) {
            if (endTimes[i].
                  isEventCondition(
                    )) {
                return true;
            }
        }
        return false;
    }
    protected float selectNewInterval(float time,
                                      org.apache.batik.anim.timing.Interval interval) {
        currentInterval =
          interval;
        float dmt =
          notifyNewInterval(
            currentInterval);
        float beginEventTime =
          currentInterval.
          getBegin(
            );
        if (time >=
              beginEventTime) {
            lastRepeatTime =
              beginEventTime;
            if (beginEventTime <
                  0) {
                beginEventTime =
                  0;
            }
            toActive(
              beginEventTime);
            isActive =
              true;
            isFrozen =
              false;
            fireTimeEvent(
              SMIL_BEGIN_EVENT_NAME,
              beginEventTime,
              0);
            float d =
              getSimpleDur(
                );
            float end =
              currentInterval.
              getEnd(
                );
            while (time -
                     lastRepeatTime >=
                     d &&
                     lastRepeatTime +
                     d <
                     end) {
                lastRepeatTime +=
                  d;
                currentRepeatIteration++;
                fireTimeEvent(
                  root.
                    getRepeatEventName(
                      ),
                  lastRepeatTime,
                  currentRepeatIteration);
            }
        }
        return dmt;
    }
    protected org.apache.batik.anim.timing.Interval computeInterval(boolean first,
                                                                    boolean fixedBegin,
                                                                    float beginAfter,
                                                                    boolean incl) {
        java.util.Iterator beginIterator =
          beginInstanceTimes.
          iterator(
            );
        java.util.Iterator endIterator =
          endInstanceTimes.
          iterator(
            );
        float parentSimpleDur =
          parent.
          getSimpleDur(
            );
        org.apache.batik.anim.timing.InstanceTime endInstanceTime =
          endIterator.
          hasNext(
            )
          ? (org.apache.batik.anim.timing.InstanceTime)
              endIterator.
              next(
                )
          : null;
        boolean firstEnd =
          true;
        org.apache.batik.anim.timing.InstanceTime beginInstanceTime =
          null;
        org.apache.batik.anim.timing.InstanceTime nextBeginInstanceTime =
          null;
        for (;
             ;
             ) {
            float tempBegin;
            if (fixedBegin) {
                tempBegin =
                  beginAfter;
                while (beginIterator.
                         hasNext(
                           )) {
                    nextBeginInstanceTime =
                      (org.apache.batik.anim.timing.InstanceTime)
                        beginIterator.
                        next(
                          );
                    if (nextBeginInstanceTime.
                          getTime(
                            ) >
                          tempBegin) {
                        break;
                    }
                }
            }
            else {
                for (;
                     ;
                     ) {
                    if (!beginIterator.
                          hasNext(
                            )) {
                        return null;
                    }
                    beginInstanceTime =
                      (org.apache.batik.anim.timing.InstanceTime)
                        beginIterator.
                        next(
                          );
                    tempBegin =
                      beginInstanceTime.
                        getTime(
                          );
                    if (incl &&
                          tempBegin >=
                          beginAfter ||
                          !incl &&
                          tempBegin >
                          beginAfter) {
                        if (beginIterator.
                              hasNext(
                                )) {
                            nextBeginInstanceTime =
                              (org.apache.batik.anim.timing.InstanceTime)
                                beginIterator.
                                next(
                                  );
                            if (beginInstanceTime.
                                  getTime(
                                    ) ==
                                  nextBeginInstanceTime.
                                  getTime(
                                    )) {
                                nextBeginInstanceTime =
                                  null;
                                continue;
                            }
                        }
                        break;
                    }
                }
            }
            if (tempBegin >=
                  parentSimpleDur) {
                return null;
            }
            float tempEnd;
            if (endTimes.
                  length ==
                  0) {
                tempEnd =
                  tempBegin +
                    getActiveDur(
                      tempBegin,
                      INDEFINITE);
            }
            else {
                if (endInstanceTimes.
                      isEmpty(
                        )) {
                    tempEnd =
                      UNRESOLVED;
                }
                else {
                    tempEnd =
                      endInstanceTime.
                        getTime(
                          );
                    if (first &&
                          !firstEnd &&
                          tempEnd ==
                          tempBegin ||
                          !first &&
                          currentInterval !=
                          null &&
                          tempEnd ==
                          currentInterval.
                          getEnd(
                            ) &&
                          (incl &&
                             beginAfter >=
                             tempEnd ||
                             !incl &&
                             beginAfter >
                             tempEnd)) {
                        for (;
                             ;
                             ) {
                            if (!endIterator.
                                  hasNext(
                                    )) {
                                if (endHasEventConditions(
                                      )) {
                                    tempEnd =
                                      UNRESOLVED;
                                    break;
                                }
                                return null;
                            }
                            endInstanceTime =
                              (org.apache.batik.anim.timing.InstanceTime)
                                endIterator.
                                next(
                                  );
                            tempEnd =
                              endInstanceTime.
                                getTime(
                                  );
                            if (tempEnd >
                                  tempBegin) {
                                break;
                            }
                        }
                    }
                    firstEnd =
                      false;
                    for (;
                         ;
                         ) {
                        if (tempEnd >=
                              tempBegin) {
                            break;
                        }
                        if (!endIterator.
                              hasNext(
                                )) {
                            if (endHasEventConditions(
                                  )) {
                                tempEnd =
                                  UNRESOLVED;
                                break;
                            }
                            return null;
                        }
                        endInstanceTime =
                          (org.apache.batik.anim.timing.InstanceTime)
                            endIterator.
                            next(
                              );
                        tempEnd =
                          endInstanceTime.
                            getTime(
                              );
                    }
                }
                float ad =
                  getActiveDur(
                    tempBegin,
                    tempEnd);
                tempEnd =
                  tempBegin +
                    ad;
            }
            if (!first ||
                  tempEnd >
                  0 ||
                  tempBegin ==
                  0 &&
                  tempEnd ==
                  0 ||
                  isUnresolved(
                    tempEnd)) {
                if (restartMode ==
                      RESTART_ALWAYS &&
                      nextBeginInstanceTime !=
                      null) {
                    float nextBegin =
                      nextBeginInstanceTime.
                      getTime(
                        );
                    if (nextBegin <
                          tempEnd ||
                          isUnresolved(
                            tempEnd)) {
                        tempEnd =
                          nextBegin;
                        endInstanceTime =
                          nextBeginInstanceTime;
                    }
                }
                org.apache.batik.anim.timing.Interval i =
                  new org.apache.batik.anim.timing.Interval(
                  tempBegin,
                  tempEnd,
                  beginInstanceTime,
                  endInstanceTime);
                return i;
            }
            if (fixedBegin) {
                return null;
            }
            beginAfter =
              tempEnd;
        }
    }
    protected void reset(boolean clearCurrentBegin) {
        java.util.Iterator i =
          beginInstanceTimes.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.InstanceTime it =
              (org.apache.batik.anim.timing.InstanceTime)
                i.
                next(
                  );
            if (it.
                  getClearOnReset(
                    ) &&
                  (clearCurrentBegin ||
                     currentInterval ==
                     null ||
                     currentInterval.
                     getBeginInstanceTime(
                       ) !=
                     it)) {
                i.
                  remove(
                    );
            }
        }
        i =
          endInstanceTimes.
            iterator(
              );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.InstanceTime it =
              (org.apache.batik.anim.timing.InstanceTime)
                i.
                next(
                  );
            if (it.
                  getClearOnReset(
                    )) {
                i.
                  remove(
                    );
            }
        }
        if (isFrozen) {
            removeFill(
              );
        }
        currentRepeatIteration =
          0;
        lastRepeatTime =
          UNRESOLVED;
        isActive =
          false;
        isFrozen =
          false;
        lastSampleTime =
          UNRESOLVED;
    }
    public void parseAttributes(java.lang.String begin,
                                java.lang.String dur,
                                java.lang.String end,
                                java.lang.String min,
                                java.lang.String max,
                                java.lang.String repeatCount,
                                java.lang.String repeatDur,
                                java.lang.String fill,
                                java.lang.String restart) {
        if (!hasParsed) {
            parseBegin(
              begin);
            parseDur(
              dur);
            parseEnd(
              end);
            parseMin(
              min);
            parseMax(
              max);
            if (this.
                  min >
                  this.
                    max) {
                this.
                  min =
                  0.0F;
                this.
                  max =
                  INDEFINITE;
            }
            parseRepeatCount(
              repeatCount);
            parseRepeatDur(
              repeatDur);
            parseFill(
              fill);
            parseRestart(
              restart);
            hasParsed =
              true;
        }
    }
    protected void parseBegin(java.lang.String begin) {
        try {
            if (begin.
                  length(
                    ) ==
                  0) {
                begin =
                  SMIL_BEGIN_DEFAULT_VALUE;
            }
            beginTimes =
              org.apache.batik.anim.timing.TimingSpecifierListProducer.
                parseTimingSpecifierList(
                  TimedElement.this,
                  true,
                  begin,
                  root.
                    useSVG11AccessKeys,
                  root.
                    useSVG12AccessKeys);
        }
        catch (org.apache.batik.parser.ParseException ex) {
            throw createException(
                    "attribute.malformed",
                    new java.lang.Object[] { null,
                    SMIL_BEGIN_ATTRIBUTE });
        }
    }
    protected void parseDur(java.lang.String dur) {
        if (dur.
              equals(
                SMIL_MEDIA_VALUE)) {
            durMedia =
              true;
            simpleDur =
              UNRESOLVED;
        }
        else {
            durMedia =
              false;
            if (dur.
                  length(
                    ) ==
                  0 ||
                  dur.
                  equals(
                    SMIL_INDEFINITE_VALUE)) {
                simpleDur =
                  INDEFINITE;
            }
            else {
                try {
                    simpleDur =
                      parseClockValue(
                        dur,
                        false);
                }
                catch (org.apache.batik.parser.ParseException e) {
                    throw createException(
                            "attribute.malformed",
                            new java.lang.Object[] { null,
                            SMIL_DUR_ATTRIBUTE });
                }
                if (simpleDur <
                      0) {
                    simpleDur =
                      INDEFINITE;
                }
            }
        }
    }
    protected float parseClockValue(java.lang.String s,
                                    boolean parseOffset)
          throws org.apache.batik.parser.ParseException {
        org.apache.batik.parser.ClockParser p =
          new org.apache.batik.parser.ClockParser(
          parseOffset);
        class Handler implements org.apache.batik.parser.ClockHandler {
            protected float
              v =
              0;
            public void clockValue(float newClockValue) {
                v =
                  newClockValue;
            }
            public Handler() {
                super(
                  );
            }
        }
        ;
        Handler h =
          new Handler(
          );
        p.
          setClockHandler(
            h);
        p.
          parse(
            s);
        return h.
                 v;
    }
    protected void parseEnd(java.lang.String end) {
        try {
            endTimes =
              org.apache.batik.anim.timing.TimingSpecifierListProducer.
                parseTimingSpecifierList(
                  TimedElement.this,
                  false,
                  end,
                  root.
                    useSVG11AccessKeys,
                  root.
                    useSVG12AccessKeys);
        }
        catch (org.apache.batik.parser.ParseException ex) {
            throw createException(
                    "attribute.malformed",
                    new java.lang.Object[] { null,
                    SMIL_END_ATTRIBUTE });
        }
    }
    protected void parseMin(java.lang.String min) {
        if (min.
              equals(
                SMIL_MEDIA_VALUE)) {
            this.
              min =
              0;
            minMedia =
              true;
        }
        else {
            minMedia =
              false;
            if (min.
                  length(
                    ) ==
                  0) {
                this.
                  min =
                  0;
            }
            else {
                try {
                    this.
                      min =
                      parseClockValue(
                        min,
                        false);
                }
                catch (org.apache.batik.parser.ParseException ex) {
                    this.
                      min =
                      0;
                }
                if (this.
                      min <
                      0) {
                    this.
                      min =
                      0;
                }
            }
        }
    }
    protected void parseMax(java.lang.String max) {
        if (max.
              equals(
                SMIL_MEDIA_VALUE)) {
            this.
              max =
              INDEFINITE;
            maxMedia =
              true;
        }
        else {
            maxMedia =
              false;
            if (max.
                  length(
                    ) ==
                  0 ||
                  max.
                  equals(
                    SMIL_INDEFINITE_VALUE)) {
                this.
                  max =
                  INDEFINITE;
            }
            else {
                try {
                    this.
                      max =
                      parseClockValue(
                        max,
                        false);
                }
                catch (org.apache.batik.parser.ParseException ex) {
                    this.
                      max =
                      INDEFINITE;
                }
                if (this.
                      max <
                      0) {
                    this.
                      max =
                      0;
                }
            }
        }
    }
    protected void parseRepeatCount(java.lang.String repeatCount) {
        if (repeatCount.
              length(
                ) ==
              0) {
            this.
              repeatCount =
              UNRESOLVED;
        }
        else
            if (repeatCount.
                  equals(
                    SMIL_INDEFINITE_VALUE)) {
                this.
                  repeatCount =
                  INDEFINITE;
            }
            else {
                try {
                    this.
                      repeatCount =
                      java.lang.Float.
                        parseFloat(
                          repeatCount);
                    if (this.
                          repeatCount >
                          0) {
                        return;
                    }
                }
                catch (java.lang.NumberFormatException ex) {
                    throw createException(
                            "attribute.malformed",
                            new java.lang.Object[] { null,
                            SMIL_REPEAT_COUNT_ATTRIBUTE });
                }
            }
    }
    protected void parseRepeatDur(java.lang.String repeatDur) {
        try {
            if (repeatDur.
                  length(
                    ) ==
                  0) {
                this.
                  repeatDur =
                  UNRESOLVED;
            }
            else
                if (repeatDur.
                      equals(
                        SMIL_INDEFINITE_VALUE)) {
                    this.
                      repeatDur =
                      INDEFINITE;
                }
                else {
                    this.
                      repeatDur =
                      parseClockValue(
                        repeatDur,
                        false);
                }
        }
        catch (org.apache.batik.parser.ParseException ex) {
            throw createException(
                    "attribute.malformed",
                    new java.lang.Object[] { null,
                    SMIL_REPEAT_DUR_ATTRIBUTE });
        }
    }
    protected void parseFill(java.lang.String fill) {
        if (fill.
              length(
                ) ==
              0 ||
              fill.
              equals(
                SMIL_REMOVE_VALUE)) {
            fillMode =
              FILL_REMOVE;
        }
        else
            if (fill.
                  equals(
                    SMIL_FREEZE_VALUE)) {
                fillMode =
                  FILL_FREEZE;
            }
            else {
                throw createException(
                        "attribute.malformed",
                        new java.lang.Object[] { null,
                        SMIL_FILL_ATTRIBUTE });
            }
    }
    protected void parseRestart(java.lang.String restart) {
        if (restart.
              length(
                ) ==
              0 ||
              restart.
              equals(
                SMIL_ALWAYS_VALUE)) {
            restartMode =
              RESTART_ALWAYS;
        }
        else
            if (restart.
                  equals(
                    SMIL_WHEN_NOT_ACTIVE_VALUE)) {
                restartMode =
                  RESTART_WHEN_NOT_ACTIVE;
            }
            else
                if (restart.
                      equals(
                        SMIL_NEVER_VALUE)) {
                    restartMode =
                      RESTART_NEVER;
                }
                else {
                    throw createException(
                            "attribute.malformed",
                            new java.lang.Object[] { null,
                            SMIL_RESTART_ATTRIBUTE });
                }
    }
    public void initialize() { for (int i =
                                      0; i <
                                           beginTimes.
                                             length;
                                    i++) {
                                   beginTimes[i].
                                     initialize(
                                       );
                               }
                               for (int i =
                                      0; i <
                                           endTimes.
                                             length;
                                    i++) {
                                   endTimes[i].
                                     initialize(
                                       );
                               } }
    public void deinitialize() { for (int i =
                                        0;
                                      i <
                                        beginTimes.
                                          length;
                                      i++) {
                                     beginTimes[i].
                                       deinitialize(
                                         );
                                 }
                                 for (int i =
                                        0;
                                      i <
                                        endTimes.
                                          length;
                                      i++) {
                                     endTimes[i].
                                       deinitialize(
                                         );
                                 } }
    public void beginElement() { beginElement(
                                   0); }
    public void beginElement(float offset) {
        float t =
          root.
          convertWallclockTime(
            java.util.Calendar.
              getInstance(
                ));
        org.apache.batik.anim.timing.InstanceTime it =
          new org.apache.batik.anim.timing.InstanceTime(
          null,
          t +
            offset,
          true);
        addInstanceTime(
          it,
          true);
    }
    public void endElement() { endElement(
                                 0); }
    public void endElement(float offset) {
        float t =
          root.
          convertWallclockTime(
            java.util.Calendar.
              getInstance(
                ));
        org.apache.batik.anim.timing.InstanceTime it =
          new org.apache.batik.anim.timing.InstanceTime(
          null,
          t +
            offset,
          true);
        addInstanceTime(
          it,
          false);
    }
    public float getLastSampleTime() { return lastSampleTime;
    }
    public float getCurrentBeginTime() { float begin;
                                         if (currentInterval ==
                                               null ||
                                               (begin =
                                                  currentInterval.
                                                    getBegin(
                                                      )) <
                                               lastSampleTime) {
                                             return java.lang.Float.
                                                      NaN;
                                         }
                                         return begin;
    }
    public boolean canBegin() { return currentInterval ==
                                  null ||
                                  isActive &&
                                  restartMode !=
                                  RESTART_NEVER;
    }
    public boolean canEnd() { return isActive;
    }
    public float getHyperlinkBeginTime() {
        if (isActive) {
            return currentInterval.
              getBegin(
                );
        }
        if (!beginInstanceTimes.
              isEmpty(
                )) {
            return ((org.apache.batik.anim.timing.InstanceTime)
                      beginInstanceTimes.
                      get(
                        0)).
              getTime(
                );
        }
        return java.lang.Float.
                 NaN;
    }
    protected void fireTimeEvent(java.lang.String eventType,
                                 float time,
                                 int detail) {
        java.util.Calendar t =
          (java.util.Calendar)
            root.
            getDocumentBeginTime(
              ).
            clone(
              );
        t.
          add(
            java.util.Calendar.
              MILLISECOND,
            (int)
              java.lang.Math.
              round(
                time *
                  1000.0));
        fireTimeEvent(
          eventType,
          t,
          detail);
    }
    void eventOccurred(org.apache.batik.anim.timing.TimingSpecifier t,
                       org.w3c.dom.events.Event e) {
        java.util.Set ts =
          (java.util.HashSet)
            handledEvents.
            get(
              e);
        if (ts ==
              null) {
            ts =
              new java.util.HashSet(
                );
            handledEvents.
              put(
                e,
                ts);
        }
        ts.
          add(
            t);
        root.
          currentIntervalWillUpdate(
            );
    }
    protected abstract void fireTimeEvent(java.lang.String eventType,
                                          java.util.Calendar time,
                                          int detail);
    protected abstract void toActive(float begin);
    protected abstract void toInactive(boolean stillActive,
                                       boolean isFrozen);
    protected abstract void removeFill();
    protected abstract void sampledAt(float simpleTime,
                                      float simpleDur,
                                      int repeatIteration);
    protected abstract void sampledLastValue(int repeatIteration);
    protected abstract org.apache.batik.anim.timing.TimedElement getTimedElementById(java.lang.String id);
    protected abstract org.w3c.dom.events.EventTarget getEventTargetById(java.lang.String id);
    protected abstract org.w3c.dom.events.EventTarget getRootEventTarget();
    public abstract org.w3c.dom.Element getElement();
    protected abstract org.w3c.dom.events.EventTarget getAnimationEventTarget();
    public abstract boolean isBefore(org.apache.batik.anim.timing.TimedElement other);
    protected abstract boolean isConstantAnimation();
    public org.apache.batik.anim.AnimationException createException(java.lang.String code,
                                                                    java.lang.Object[] params) {
        org.w3c.dom.Element e =
          getElement(
            );
        if (e !=
              null) {
            params[0] =
              e.
                getNodeName(
                  );
        }
        return new org.apache.batik.anim.AnimationException(
          this,
          code,
          params);
    }
    protected static final java.lang.String
      RESOURCES =
      "org.apache.batik.anim.resources.Messages";
    protected static org.apache.batik.i18n.LocalizableSupport
      localizableSupport =
      new org.apache.batik.i18n.LocalizableSupport(
      RESOURCES,
      org.apache.batik.anim.timing.TimedElement.class.
        getClassLoader(
          ));
    public static void setLocale(java.util.Locale l) {
        localizableSupport.
          setLocale(
            l);
    }
    public static java.util.Locale getLocale() {
        return localizableSupport.
          getLocale(
            );
    }
    public static java.lang.String formatMessage(java.lang.String key,
                                                 java.lang.Object[] args)
          throws java.util.MissingResourceException {
        return localizableSupport.
          formatMessage(
            key,
            args);
    }
    public static java.lang.String toString(float time) {
        if (java.lang.Float.
              isNaN(
                time)) {
            return "UNRESOLVED";
        }
        else
            if (time ==
                  java.lang.Float.
                    POSITIVE_INFINITY) {
                return "INDEFINITE";
            }
            else {
                return java.lang.Float.
                  toString(
                    time);
            }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVdC3xUxbmf3ewGCIQ8kIc8gkBAeSUKUh/4aAiJxG5CTCDW" +
       "IMST3ZNkZbNnOTsbApWC9NcL6q31KtpeFXqv0lrQAn1aa7VUWyu1L99Vr0pt" +
       "e2tL/Ym3D9uq9X7fzOyes2fPzOZs2fx+O7s5Z76Z7/+fb755njkPvEWCSZPU" +
       "6HFaR7ck9GRdU5y2a2ZSjzTGtGRyDVzrCX+uRPvThjfbLvCT0m4yfkBLtoa1" +
       "pN4c1WORZDeZEY0nqRYP68k2XY+gRLupJ3VzSKNRI95NJkaTLYOJWDQcpa1G" +
       "RMcIXZoZIlUapWa0N0X1FpEAJTNCoEk906S+wXl7eYiMCxuJLVb0KbbojbY7" +
       "GHPQyitJSWXoWm1Iq0/RaKw+FE3S5cMmWZgwYlv6Ywat04dp3bWxZYKCy0PL" +
       "ciiYfaTir+/dMlDJKJigxeMGZfCSHXrSiA3pkRCpsK42xfTB5CbySVISImNt" +
       "kSmpDaUzrYdM6yHTNForFmhfrsdTg40Gg0PTKZUmwqgQJbOyE0lopjYokmln" +
       "OkMKo6nAzoQB7RkZtBxlDsTbF9bv+dyGyq+VkIpuUhGNd6I6YVCCQibdQKg+" +
       "2KubyYZIRI90k6o4FHanbka1WHSrKOnqZLQ/rtEUFH+aFryYSugmy9PiCsoR" +
       "sJmpMDXMDLw+ZlDiv2BfTOsHrJMsrBxhM14HgGVRUMzs08DuhEhgYzQeoWSm" +
       "UyKDsfZjEAFERw3qdMDIZBWIa3CBVHMTiWnx/vpOML14P0QNGmCAJiVTpYki" +
       "1wktvFHr13vQIh3x2vktiDWGEYEilEx0RmMpQSlNdZSSrXzearvo5k/EV8X9" +
       "xAc6R/RwDPUfC0I1DqEOvU83dagHXHDcgtAd2qRHdvsJgcgTHZF5nAeve+ej" +
       "i2qOPsnjTHOJs7r3Wj1Me8L7e8c/Pb1x/gUlqMbohJGMYuFnIWe1rF3cWT6c" +
       "AA8zKZMi3qxL3zza8cRVOw7qJ/ykrIWUho1YahDsqCpsDCaiMd28TI/rpkb1" +
       "SAsZo8cjjex+CxkFv0PRuM6vru7rS+q0hQRi7FKpwf4HivogCaSoDH5H431G" +
       "+ndCowPs93CCEFIJH7IcPgsJ/2PflFxdP2AM6vVaWItH40Z9u2kg/mQ9eJxe" +
       "4HagvhesfmN90kiZYIL1htlfr4EdDOjiBohBpYwOgh3Vr4kO6hF0Cuhn0coS" +
       "RU5/GPFN2OzzAfXTnRU/BnVmlRGL6GZPeE9qRdM7h3qe4kaFFUEwQ8l8yLKO" +
       "Z1nHsqzDLOt4lnX2LInPx3I6DbPmBQzFsxEqOnjacfM7119+ze7ZJWBZic0B" +
       "4Bajzs5qcRotb5B24T3hw9XlW2e9ds7jfhIIkWotTFNaDBuQBrMfXFN4o6i9" +
       "43qhLbKahDNsTQK2ZaYR1iPgkWRNg0hltDGkm3idktNsKaQbLKya9fLmwlV/" +
       "cvTzm6/v2n62n/izWwHMMggODMXb0XdnfHSts/a7pVux682/Hr5jm2H5gaxm" +
       "Jd0a5kgihtlOW3DS0xNecIb2zZ5HttUy2seAn6Ya1CtwgTXOPLLczPK0y0Ys" +
       "owFwn2EOajG8lea4jA6YxmbrCjPSKvb7NDCLsVjvJsPnpKiI7BvvTkpgOJkb" +
       "NdqZAwVrEi7uTOz95c9+v5TRnW49KmzNfqdOl9s8FiZWzXxTlWW2a0xdh3iv" +
       "fr79ttvf2rWO2SzEmOOWYS2GjeCpoAiB5k8/ueml11/b/5zfsnMKTXaqF3o+" +
       "wxmQeJ2UKUBCbvMsfcDjxcAroNXUro2DfUb7olpvTMeK9X7F3HO++cebK7kd" +
       "xOBK2owW5U/Aun76CrLjqQ3v1rBkfGFscS3OrGjcjU+wUm4wTW0L6jF8/TMz" +
       "/vNH2l5oEMAJJ6NbdeZXCeOAsEJbxvCfzcJzHffOw2Bu0m782fXL1jPqCd/y" +
       "3MnyrpOPvsO0ze5a2cu6VUss5+aFwbxhSH6y0zmt0pIDEO/co21XV8aOvgcp" +
       "dkOKYXC2ydUmOMfhLMsQsYOjXv7+45OuebqE+JtJWczQIs0aq2RkDFi3nhwA" +
       "vzqcuPSjvHA3j043MMMkB3zOBSR4pnvRNQ0mKCN767cnf+Oi+/a9xqwswdOY" +
       "xuTno6vP8qqsg25V7IPPnvf8ff9xx2bexM+XezOH3JR/rI717nzjbzmUMz/m" +
       "0v1wyHfXP3D31MZLTjB5y6GgdO1wbvMETtmSXXJw8C/+2aU/9JNR3aQyLDrE" +
       "XVoshdW0GzqByXQvGTrNWfezO3S897I84zCnO52ZLVunK7OaRfiNsfF3ucN7" +
       "TcEiXASfOlGx65zeizWR3KJQpboW6L/262b1G/+1/93rd53vx+oTHELVgZVK" +
       "K15bCvvd//bA7TPG7jl+Eyv4dNItLPszWbgAg8XMFErwZx14nyTrwlOAE41r" +
       "MYcXmqxQlpKxzS2hUE9HU+vqrqbs9hrbxM5UbxLaVugK0OiQ6GYuab8mvLu2" +
       "/Tfcvk53EeDxJn65/jNdL177E+aoR2PrvSbNqa1thlbe1kpUctU/hD8ffP6J" +
       "H1QZL/DuWnWj6DOekek0Yv1QGroDQP226tc33v3mVzgAp1U7Iuu799z4Yd3N" +
       "e7j35SOPOTmdf7sMH31wOBhcidrNUuXCJJp/d3jbw1/etotrVZ3dj26CYeJX" +
       "XvjgJ3WfP37MpQtXEhWjR3Qzvkzn67TssuGAVt5Q8d1bqkuaod1vIaNT8eim" +
       "lN4Sybb+UclUr62wrBGNVSMENCwY6BcugDLgrTaG52NwOTfD5VIf2Zhbp+qF" +
       "mda71Cn88TEEhj/6VRUCg3YMrnCpCbIs0jWhuaOpqbsJL3U5AA14BHQ+fJaI" +
       "3JYoALHriYIBybKgZHxHU+eaho41PQ2hKxuu6nTDtKkATEtFhkvzFdKWgjHJ" +
       "sqBkchrTlaua2nraVgO4xjUtXa4FtrUAcOeKnM9VgPPjj50Fg5NlQUl5Glxb" +
       "U1dThxukT3mE1Aif80R+57lAMkmF1QA1QzeHvvzWsXteuejkH8HLNKebKYwe" +
       "2r6DS99UMHCZIpSUtbStbGpuaWtZ08TE1gi/iV9X2X6vxyYOtXQ6O/w37PRA" +
       "/+6RrGXCBtK24Fb+n9l+lF+/s2AaZFkADWvbwAJWh7qaVuKV2xx47ho5nvF4" +
       "dS58LhaZXZyDh7Af97rDgCHNmIRpUOhL6REHhnJFspQETMPgxTOFkrr8Uwsr" +
       "jXAK5xY6QMyBd79HvHPgs0IotkKC9xDHi8GXcmHJpHGAp8EQOANsQV5gjfb+" +
       "rw3UYY+gcJbqMqHWZRJQDypByaTB3nr1/mgctU1mLw5kenJs8Mf7DVePfeJ7" +
       "yXv/92u8f+LWT3RMR375vtHhVwafYP1EzHBtNrAZKmCgzlx5f86m1b4vzfnZ" +
       "9n1zfsVGdaOjSejeQ4/SZYLVJnPygddPPFM+4xCb+QhgxxQzLXfOTOdOPGfN" +
       "JzNMFRh8bzhtFovymQV8dSb0MAzOdTOnw8ZKnycoCvYJ99rpzziZK5gWV4J9" +
       "xvR4P5/uvBqDxxLWuNPPhdJKTrA8fmPMiOs4TZC+x2f2okZdZsYfbg7naGqS" +
       "GVkj0FbGizWce3X8rb9+qLZ/hZcpPbxWk2fSDv+fCYW7QG4bTlV+tPMPU9dc" +
       "MnCNh9m5mQ7TcSZ5oPWBY5fNC9/qZ4sKfJyZsxiRLbQ8u39dZuo0Zcaze9Rz" +
       "eNGz0rMq9EJWwIp5lRcV917C4DloNMNY0NwuFNH/J3eqAi80JGyzGqoG99se" +
       "fdt8+ISECwhJfNuvlL5NJk3JaD0eYZ4N/3/UoegbHhWtgU+HyKpDouibSkVl" +
       "0tDOJqODiZi+MsVaCmeb/3uPms6Ez8dFXh+XaPq2UlOZNFAaSZmteiSq5euj" +
       "jeo1jJiuxUdkNCc9IjwDPhuEjhskCN9TIpRJwxDQ1BO6RhuNVJy6lcb7BdhN" +
       "ROQWcdfV51fqKpMGu+G6utuNr6SAqhgVeUUlmo5RaiqTpmRSOGVi56mDKdxC" +
       "cdZGTMw7xje+sgK6fHGRcVyidqVSbZk0DJ9jWlLojI7EjeUqj+pOIziFxf+o" +
       "RN3JSnVl0lA7+6Ix1si68TqlAMPdKrLaKlG0RqmoTJpVMmgUTSrTdaZHXXHs" +
       "tkPktkOi61ylrjJpSkqgx+ZW8PMKcMufFrl8WqLjIqWOMmkoeNCRuWX8/88O" +
       "RRcXQOZNIqubJIouVSoqk0Yy+Xq1k8xzCyDzFpHLLRIdL1TqKJNGMrVhKZnL" +
       "C1D0dpHV7RJFG5SKyqQpjnUawjiB7KboigIUvVNkdadE0VVKRWXSTNFm09iq" +
       "x90UbSnA339BZPUFiaKrlYrKpIW/79SwMybz9+0FqLtfZLhfom6XUl2ZNKib" +
       "af8zralT3Ss9qoszUgdEhgck6q5XqiuTpqSazTWkx0PpOYcZbtMI2ma2G6on" +
       "fPWZlZNqL/jTbLFQ4xLXtm3q5oe/0919ZmU4Pd3wSDa2ahU2XDbOGtBaOty/" +
       "Mdbw9vlfupjrMEsy8LTiP3TF8af3bj38AF+lwQEuJQtlmwFzdyDi5g3FzIcN" +
       "718uu/Do73/dtT6NdzyWjp6ZihhvXwZnWwZ8G0fSH/dt8Gg0H4HPIUHsIYnR" +
       "JJRGI5OmpBIGcVkmg4lFHAp7WMNgCp8Jn6+LLL8uUXizUmGZNCUVoquLa77m" +
       "kBZLl8Zc5cRQOrYD2LBHYLXweUio9pAE2A4lMJk0AEPnmNazKR5xczfXe9T3" +
       "LPg8LnJ8XKLvLqW+MmmwnISpD0WNVNLGre86h8K7PSp8EXyOiSyPSRS+Wamw" +
       "TBoIZv5xJfj0eAQnmpmp9+Z2zqT5M4E+DPZknIDrRj2McseIXMFnPfJzIXx+" +
       "LvT7uYSfu5T8yKQp7pSOWOxgSk7zu9ujthfA53mR3/MSbe9RaiuTpmRacsBI" +
       "xSJrExGN6o3ZPgGjOPtB9xYwCfKyyP1lie4HlLrLpCkZM6AleavkpulBj5qe" +
       "DZ/jIq/jEk2PKDWVSYNNDGjxSEyPNA3JakyVKnerxnwrU2PKrRrTqjHlvj2i" +
       "qvJVj7TMgs9vhWK/ldDyiJIWmTTFzVKsGwtNi1sJPlpAs3JCZHZCouoPlKrK" +
       "pFkJJttNI6H140YeN21/OHJtcXYFtwwE3+dRg+/laOuj5Cz3ptjUxQ7sulbo" +
       "mWr9vK/xFMfFQucq730YuK7yTk3n7aID1C9c413b0djUmTY62yYw/kCCg4Of" +
       "jJyDiXh1NSGlfh611CcpsRfckfktZA5Qp6UTc0kUuvcxI5xeL+pMJRKGmVkr" +
       "zSU8es758bpQjoAD9YsK1MMK7etgzKnB2MDUwtTCwP4qiGP7vw0DiznNthQH" +
       "qs/JUZ15hs7WllDmoR0cPMyQPc3Bdnbt37lnX2T1F89J99Q3gA1QI7E4pg/p" +
       "MVu2fCrgFxmVZ6Rr34dC5Q+dZWkxxteKskusTCHKYrquAvlOKu79HwYnKBnV" +
       "r2dW7A9aRfbHfIaq3heLFxoSDhbQheN8pK+Up8m/PbEgFVUg/UBx70MM/gbe" +
       "C1jgkzCZCQOLi78Xk4tyAajcOxcyUTlef5ni3jgMgpyLzmjW5EmGC39pEbhg" +
       "lXoOAJksAE3Ow0VuwyQVdeB1LKCrH5ixj1dR4M+MJhW90zCohiGAFok4pW0k" +
       "TigWifOAAbGL0JezUTE/iTJRdxIRyRSLl3kKXs7CYBa0LaY+aAzpCmpmF4ua" +
       "MwGXWC705Sw25qdGJjoiapYqqFmGATR0E6I2UhqhO9zPe1E2buqLwA3rF4YA" +
       "WEIATDgAjoAbmai67nnaYWNx+VEFl7jXzr+cknFQ/bJGmM5l7cCQEY1YxF5U" +
       "LGIhmu+Tgp1t3ondJhGVG12DRVSHgihc8fe3gp/i9THDFV5utnhpK1bDB/0h" +
       "n1hd8uWsTTl4cWn4ZKIKxD2Ke7hC5O8Gs8k0fOmleIuKdUWgYireQ5e9V+DZ" +
       "q6DCvYOMgbN7X6VI0cGCbRx8G6NiUEETPo3r7weaosm1cVM8GM7szaIp7876" +
       "f8VixAqKL2f9Jb/FyESlNYlPiXJStipIwYlIf4rbDu9A5trOULHaNCRFzCL6" +
       "cmYR87sXmeiISNmlIOUGDHbC2Ah8eCrp0srn3fxeKCNnAJwXBKwXvDMiEx0R" +
       "I3sUjNyBwWfBTAZTMRpNxLa4kHJLsUiZBoiOC2THvZMiEx0RKf+tIOVeDO6G" +
       "Iegg37rs4GNvMfn4uwD1d+98yERHxMchBR9HMDiAfGjDLnzkna8tlI/ZoGY1" +
       "T5N/e+JDKqpA+rDi3iMYfIuS8eBR06fQ5PrUB4tFxlxAcrpAdLp3MmSi0obX" +
       "dx1D/aSCkR9j8DglVXGDRvu2tOmb7QsQNlJ+UCxSzgJEywSyZd5JkYnmI+V5" +
       "BSkvYvALSk7jpHSIgaUrL08Xi5fpAOoqAe4q77zIRPN4Et6/f0NBzm8weJWS" +
       "0Um2CaaBOgh5rQiETMJ7CwkpWcXT5N+eCJGKKqC+rbj3DgZ/oGQijG5WaUm2" +
       "uNRoxCPRzGMDtq7riSJ6lBJR0iXejUQqqjYSUYPeV7DzTwzeBbeS1PHUArlb" +
       "+VsRmGHzdDD2Kdkp4O30zoxM1IE5wBQJsOLOBFZFKhkj56hkLAYB3A1iDCbY" +
       "wWa2PQgZhkqCxZpAWAqKl/E0+bcnhqSiUscrKJmkoATntUqqKAnikXGOGYOS" +
       "6iIQwU6ZqQcU4uiDgHO9J//4L7BQIurAOYYpMgZL95mRBoyUOQrC5mJQAzaU" +
       "wKX4zBl5SQd1eTdLF2pDgDmwUuBf6d2GZKLyxptTcraCkiUYLKSkjFGyAvfL" +
       "ONhYVCw2zgQoXQJSl3c2ZKL52LhYwcalGJxP8VA6YIP3de1cXFDENZeAmLwN" +
       "eJ/3lYpKWyZWY4SLudydMfb/FErm5cwOM3JMfghi03BYT2AjzpIKYdCUrmCN" +
       "MSO8kZ0nsymrGStpLqZJfUpw8SnvNMpE85nUVQqTWofBmrRJ8V1+dpNaW0wu" +
       "bhWAbvXOhUw0Hxd9Ci7wUdoSLc1Fa46r6S0mFwcFoIPeuZCJ5uMiqeAihUE8" +
       "wwV7isPOhVEsLs4DII8JQI9550Immo+LHQoudmLwCdxgilx0ZD0vaOfkumJ2" +
       "7n4pgP3SOycy0XycfEbByWcx2E3JeBsnuQ3SDcViZD7AEVvMAjkb1PIzIhPN" +
       "x8idCkbuxuB2PEQDGWmOxmIOMu4oFhnY5f2HQPQP72TIRPORcZ+CjAMY3EPJ" +
       "OGEe7Ok/Bx95N8AWOgSYTkhwLE+Tfyv4yB0CSEUVcL+huPctDA7jFs14lLID" +
       "FnQHEUeKRUQNoBD7XYL5tsq4ECETVYD9vuLe4xh8F2wiokupeKSYVNQKPLXe" +
       "qZCJKuD+THHvFxgcAyrYEwDiqF0HFT8uFhULAMdigWexdypkolJ3wRc0Sl5R" +
       "8PEqBi+o+VDtDf2X3YU4pyqYc2BWfj5kogq4byru/QGDX4O70OMRdyJ+Uywi" +
       "zgIUIk3+7Y0ImWg+w/iLgo13MTipYuOdYm0kmA1QWgSkFu9syETlYAN+xT2c" +
       "lSz5gJKqfp2Gch9atfj4Z7H4ANcXvEKAusI7HzJRBeYKxT08/DdQRskE4EM8" +
       "bLMifbJVNiOBsUVgZALemwZw1gtY670zIhNVoJ6uuFeDAT58Hdbi6Yky27JF" +
       "IO95EIXScDpg0AUW3TsNMlEF1PmKe3h4UqCWklKgQTy0aCNhbrFqxzxAIM4V" +
       "CeacSpKfBJmoAuhHFPcY1nMomQi1Y9WWhG7GovGNsvqxpFjjkssB0HYBbHse" +
       "TnLHJVJRB+4Spgg+nsNnDW/DoIvR0KigCI8PDVxCSXlf1GR+lC36bcpqXAKX" +
       "FoEadm8J4LpR4LtRQQ0LbZv5iGMLX0CRjgO8ffMnuziFkik4ebp5abguYgzW" +
       "6eyRujrGA6PoCgV9azH4GD6jidFXh9lD0I7Jw0CoWOuBywDuXQJ2zuEVCvoy" +
       "jzr53nAQOSmdkkuKCoNLE1ltO9tdi0FnRTMtM9QUPGJlDKzLY4ZXF4vHcwDt" +
       "PQL1PaeMR1mKeTqCgU0KnvBiYCO0btTInIFipyhWLIpaAcj9AtD9p4wiWYrS" +
       "OitWpBkX2xU8XY/BFugwU6MlrrkxlfeI5EKZwuHDEYHryCljSpaiggPFvGUA" +
       "5y0Duygex4j7gHKn6QJ5TwgolJ8LAcXDAs13Thk/35GkKHVaYpOh5Z7uUtC1" +
       "FwOc1OT7gyINTtdUjElNxlYDYBJnPQRzTooomC1ZinLXxDk6oODofgzupaRS" +
       "cITDs/Syop2qvGcbF0AVm486DwA9KYA9");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("ecqokqUopYpPCwceVFD1EAZf5aM2+1umVmxpiaSb0pG/m8qi9mtFoBYPcmId" +
       "jZ8KIn56yqiVpZiP2h8pqD2GwfehJwLUsj7EGs2En3Zma2S9PR7VovOxYtL5" +
       "rAD/7CmjU5aigi3FCboBPEE38DRnEh94tlGEd56yeHqmCDxNx3s4mnxJoHrJ" +
       "K091bjxNUKSo4OK3inu/w+B1aErR4mw1Es+btltaTm09Xizzwhb2dQHy9VNm" +
       "XrIUFdQopjQDOKUZeJuSyfggEHg2/lZRqY3lPSu3UBvD+TxxoEgw5ziSgm1M" +
       "lqLUtQUexsyCJXLGgkGM9gE7VnCF3meY/Blri6JiTHni8YhslC6WioOqVWZv" +
       "9iRLUcFAleLeBAzG4nPBmfdlZcwqm6jguCIQhcfGksUAR7z1Lih5tR8jCgOX" +
       "2S+ZqAO1fX8Yu/hdceL9UfGdfa4Kfy9YIpGQnGTO2KtRMIv7MYOn455eU9eo" +
       "tZcsnZfkWBmrUmcJsBKYWoQSYI/TLCSkdBRPk397rc1uT4dKU3SvzdllwI8g" +
       "wxNf2Ntkgopn24P4osDgYhxm6JSLbMrqOwfrisAbe/JmNqAbL1COP2W8yVJU" +
       "UKCYqwziXGXwYqCn30ZP8FyLnkuKRQ90REonCTCTThk9shQV9R1RzmRkOGcl" +
       "HcY323aaVzSZhDFDhzjmKWsvaLATA5zAZC8zpeIEKMu3MF6LMYHJeJ0F6GsE" +
       "CzWnjFdZitLGl0+8BRUTlMEwBuvYxFvmoCo7RadkbnKYknH2kR2+LnNKzkvN" +
       "+Yu4w4f2VYyevG/ti/xdLumXZY8LkdF9qVjM/kJH2+/ShKn3RRm141hYxd5e" +
       "F9xIyXTVgJOSUv4DVQ9ey4XilEx0FaIkgF/2uJvAHzrjUhJk3/Z4FDrSVjzI" +
       "lv+wR9lMSQlEwZ+MuOCsYW720+z0YqmQiflKJSNifwMunj3L3jifPnM31S6O" +
       "uD287/K2T7zzkS/yN/CGY9rWrZjK2BAZxV8GzBItyTku155aOq3SVfPfG39k" +
       "zNz02VhVXGHL6qdZ5ofTQL4EmsNUx+tpk7WZt9S+tP+iR3+6u/QZP/GtIz4N" +
       "ukLrcl8POpxImWTGulDu+xG7NJO9N3f5/Du3XLKo7+1X0u/h9GW/dtUZvyf8" +
       "3H3rn711yv4aPxnbQoLReEQfZu8tXbkl3qGHh8xuUh5NNg2DipBKVItlvXxx" +
       "PFquhjWK8SLoLM9cxfc3gzvLfe9k7luvy2LGZt1cYaT4emd5iIy1rvCScbyM" +
       "JpVIOASsK6IoMezF4MphLA2wvZ5QayKRfi0nqUiwyht271yhed7AfuKvG/8f" +
       "pgzVIY2CAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+lVv3qmobLVBmpI4EZeoWYf1Zj1EDaTX");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Drr1EhcFQLWdkn7v6IDuUwzo71wfcOds");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "9c8e/qff90/e9++ycwX/PymTfMc3kwAA");
}
