package com.service;

import com.dao.InvitationDAO;
import com.dao.TraveluserDAO;
import com.entity.Invitation;
import com.entity.Traveluser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "handleInvitationServlet", urlPatterns = "/handleInvitationServlet")
public class handleInvitationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");//0: refuse, 1:agree
        String iid = request.getParameter("iid");

        if (type == null || (!type.equals("0") && !type.equals("1")) || iid == null) {
            response.getWriter().println("{\"message\": \"information not complete\"}");
            return;
        }

        InvitationDAO ivdao = new InvitationDAO();
        TraveluserDAO udao = new TraveluserDAO();
        Invitation invitation = ivdao.get(Integer.parseInt(iid));

        if (type.equals("0")) {
            invitation.setState(2);
            ivdao.updateState(invitation);
            response.getWriter().println("{\"message\": \"success\"}");
        } else {
            invitation.setState(1);
            ivdao.updateState(invitation);

            Traveluser sender = udao.get(invitation.getSenderUid());
            Traveluser receiver = udao.get(invitation.getReceiverUid());


            String senderFriendsStr = sender.getFriendsUid();
            List<String> sendList = new ArrayList<>();
            if (senderFriendsStr != null) {
                String[] senderFriends = senderFriendsStr.split(",");
                sendList.addAll(Arrays.asList(senderFriends));
            }

            sendList.add("" + receiver.getUid());

            sender.setFriendsUid(String.join(",", sendList));
            udao.update(sender);


            String receiverFriendsStr = receiver.getFriendsUid();
            List<String> receivList = new ArrayList<>();
            if (receiverFriendsStr != null) {
                String[] receiverFriends = receiverFriendsStr.split(",");
                receivList.addAll(Arrays.asList(receiverFriends));
            }


            receivList.add("" + sender.getUid());
            receiver.setFriendsUid(String.join(",", receivList));
            udao.update(receiver);


            //update Friends list
            List<Traveluser> friends = (List<Traveluser>) request.getSession().getAttribute("friends");
            friends.add(sender);
            request.getSession().setAttribute("friends", friends);


            List<Invitation> invitations =  (List<Invitation>) request.getSession().getAttribute("myInvitation");
            for (Invitation iv : invitations) {
                if (iv.getInvitationId()==invitation.getInvitationId()){
                    invitations.remove(iv);
                    break;
                }
            }
            request.getSession().setAttribute("myInvitation", invitations);



            response.getWriter().println("{\"message\": \"success\"}");
        }


    }


}
