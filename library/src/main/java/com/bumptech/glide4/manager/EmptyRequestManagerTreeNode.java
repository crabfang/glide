package com.bumptech.glide4.manager;

import android.support.annotation.NonNull;
import com.bumptech.glide4.RequestManager;

import java.util.Collections;
import java.util.Set;

/**
 * A {@link RequestManagerTreeNode} that returns no relatives.
 */
final class EmptyRequestManagerTreeNode implements RequestManagerTreeNode {
    @NonNull
    @Override
    public Set<RequestManager> getDescendants() {
        return Collections.emptySet();
    }
}
