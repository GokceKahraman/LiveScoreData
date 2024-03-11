package com.example.livescoredata.helpers;

import androidx.annotation.IdRes;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;

public abstract class NavigationUtils {

    public static void navigateSafe(NavController navController, @IdRes int resId) {
        NavDestination currentDestination = navController.getCurrentDestination();

        if (currentDestination != null) {
            NavAction navAction = currentDestination.getAction(resId);

            if (navAction != null) {
                int destinationId = orEmpty(navAction.getDestinationId());

                NavGraph currentNode;
                if (currentDestination instanceof NavGraph)
                    currentNode = (NavGraph) currentDestination;
                else
                    currentNode = currentDestination.getParent();

                if (destinationId != -1 && currentNode != null && currentNode.findNode(destinationId) != null) {
                    navController.navigate(resId);
                }
            }
        }
    }

    private static int orEmpty(Integer value) {
        return value == null ? -1 : value;
    }
}


