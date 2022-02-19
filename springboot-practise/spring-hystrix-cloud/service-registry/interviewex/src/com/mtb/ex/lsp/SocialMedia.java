package com.mtb.ex.lsp;

/**
 * @author MithileshB
 * @created 01/12/2021 - 7:53 AM
 * @project interviewex
 */
public abstract class SocialMedia {

    //supported by whatsapp ,facebook and instagram
    public abstract void chatWithFriend();

    //supported by facebook and instagram
    public abstract void publishPost();

    //supported by whatsapp,facebook and instagram
    public abstract void sendPhotosAndVideos();

    //supported by whatsapp and facebook
    public abstract void groupVideoCall(String... user);
}
