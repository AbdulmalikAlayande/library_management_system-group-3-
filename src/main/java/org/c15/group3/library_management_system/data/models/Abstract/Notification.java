package org.c15.group3.library_management_system.data.models.Abstract;

import org.c15.group3.library_management_system.data.models.Recipient;
import org.c15.group3.library_management_system.data.models.Sender;

public abstract class Notification {
    private Long id;
    private String message;
    private Sender sender;
    private Recipient recipient;
}
