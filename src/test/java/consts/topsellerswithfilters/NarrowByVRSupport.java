package consts.topsellerswithfilters;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NarrowByVRSupport {
    VR_ONLY("401"),
    VR_SUPPORTED("402");
    public final String label;
}
