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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "jnB4ll5WtFOV92zjAqhi81HnAqAnBbAn");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("TxlVshSlVPFp4cCDCqoewuCrfNRmf8vUyq0tkXRTOvJ3U1nUfq0I1OJBTqyj" +
       "8VNBxE9PGbWyFPNR+yMFtccw+D70RIBa1odYq5nw085sjay3x6NadD5WTDqf" +
       "FeCfPWV0ylJUsKU4QTeAJ+gGnuZM4gPPNorwzlMWT88UgacZeA9Hky8JVC95" +
       "5anOjacJihQVXPxWce93GLwOTSlanK1G4nnTdkvLqa3Hi2Ve2MK+LkC+fsrM" +
       "S5aighrFlGYApzQDb1MyBR8EAs/G3yoqtbG8Z+UWamM4nycOFAnmHEdSsI3J" +
       "UpS6tsDDmFmwRM5YMIjRPmDHCq7U+wyTP2NtUVSMKU88HpGN0sVScVC1yuzN" +
       "nmQpKhioUtybgMFYfC44876sjFllExUcVwSi8NhYsgTgiLfeBSWv9mNEYeAy" +
       "+yUTdaC27w9jF78rTrw/Kr6zz1Xh7wVLJBKSk8wZezUKZnE/ZvA03NNr6hq1" +
       "9pKl85IcK2NV6iwBVgLTilAC7HGaRYSUjuJp8m+vtdnt6VBpiu61ObsM+BFk" +
       "eOILe5tMUPFsexBfFBhcgsMMnXKRzVl952BdEXhjT97MAXTjBcrxp4w3WYoK" +
       "ChRzlUGcqwxeBPT02+gJnmPRc3Gx6IGOSOlkAWbyKaNHlqKiviPKWYwM56yk" +
       "w/jm2E7ziiaTMGboEMc8Ze0FDXZigBOY7GWmVJwAZfkWxmsxJjAZr7MBfY1g" +
       "oeaU8SpLUdr48om3oGKCMhjGYD2beMscVGWn6JTMTQ5TMs4+ssPXZU7Neak5" +
       "fxF3+NC+itFT9q17kb/LJf2y7HEhMrovFYvZX+ho+12aMPW+KKN2HAur2Nvr" +
       "gpsomaEacFJSyn+g6sFruFCckkmuQpQE8MsedzP4Q2dcSoLs2x6PQkfaigfZ" +
       "8h/2KFsoKYEo+JMRF5w9zM1+up1eLBUyKV+pZETsb8DFs2fZG+fTZ+6m2sUR" +
       "t4f3Xdb2iXc+8kX+Bt5wTNu2DVMZGyKj+MuAWaIlOcfl2lNLp1W6esF744+M" +
       "mZc+G6uKK2xZ/XTL/HAayJdAc5jmeD1tsjbzltqX9l/46E93lz7jJ771xKdB" +
       "V2h97utBhxMpk8xcH8p9P2KXZrL35q5YcOfWixf3vf1K+j2cvuzXrjrj94Sf" +
       "u2/Ds7dO3V/jJ2NbSDAaj+jD7L2lq7bGO/TwkNlNyqPJpmFQEVKJarGsly+O" +
       "R8vVsEYxXgSd5Zmr+P5mcGe5753Mfet1WczYopsrjRRf7ywPkbHWFV4yjpfR" +
       "pBIJh4B1RRQlhr0YXDGMpQG21xNqTSTSr+UkExOs8obdO1donjewn/jrxv8H" +
       "2oA0O42CAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "A4btpmaJSloDaTZx5SndHQpWivYabt4f");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "OejWS1zAgGo7Jf3e0QHdp+jQ37mOcOd8");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "z2e+nBptksyv9W5+7xzo6zdUXwSQ79mi33MT0Q9T/Mcd5/4sC74KCPVDhHt/" +
       "eEB4w7VOb0QIWrTbnrklfOZNJDzybsnev17zfHN3EXjRoWVozDA0XZ3Zrm1y" +
       "zXsle/85C76e9be9AJT77bInB9VwrZq/Oq9qXghU8uhWNY/e/HKf/bnpb+/4" +
       "YvNydtO9b6/721dXYTlMeaaPNZdR7umH/WM/DHKPHPlIeSDKFlDmk/JH3nfv" +
       "HQ+/j//DzRLp2drZ2eXupHJ3aLFtH1oi+/By2bf5gaqZa+w71+E9/hrj9ij3" +
       "3F3fbEa52zY7mcyXb9skuivKPXRsoii3l/0cjns3MCBH40a5y+vfw/HuA87T" +
       "QTxw283O4SgPRrlLIEq2+4wst/d+a7kpoY8cLizrj9EfuJH2ryYJco9dswKh" +
       "n61jvr9qeTzYLnT40fd1ej/0rcoH1kugX5ZtMU2zq9xB5W5fF/XNd+HZyucv" +
       "PPFq+9e6rf3y797zsTtfvP99+T0bgQ8K7iHZnn9o5Muzs1dusybk8ZbjR6ts" +
       "EbT0nz/8z77vn77v32fX8v9/k37IVDeTAAA=");
}
