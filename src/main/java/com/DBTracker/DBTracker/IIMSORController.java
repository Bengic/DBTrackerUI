package com.DBTracker.DBTracker;

import com.DBTracker.DBTracker.model.*;


import com.DBTracker.DBTracker.repo.IIMSORRepo;
import com.DBTracker.DBTracker.repo.IIMSORRepoOverview;
import com.DBTracker.DBTracker.repo.IIMSORRepoUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller

public class IIMSORController {

    @Autowired
    IIMSORRepo iimsorRepo;

    @Autowired
    IIMSORRepoOverview iimsorRepoOverview;

    @Autowired
    IIMSORRepoUpdate iimsorRepoUpdate;

    @GetMapping("/DBOverview")
    public String Overview(Model model,  HttpServletRequest request) {
        BASICVIEW basic = new BASICVIEW();
        String action =request.getParameter("_Action");
        String user = request.getParameter("user");
        String id = request.getParameter("id");
        List <DETAILVIEW> Details = new ArrayList<>();
        basic.setStatus("");
        basic.setUser(user);

        if( null != action  && action.equalsIgnoreCase("Retrieve")){
            if ( null != user && ! user.isEmpty()){
            Details.addAll( iimsorRepoOverview.getOVerviewforUser(user));
            Collections.sort(Details, Collections.reverseOrder());}else{ Details.addAll( iimsorRepoOverview.getOVerviewforALL());
                Collections.sort(Details, Collections.reverseOrder());}
        }


        if(  null != action && null != user && action.equalsIgnoreCase("Clear")){
            if (user.isEmpty()) {    basic.setStatus("Please input requesting host' name.       ");}
            else{basic.setStatus(iimsorRepoUpdate.clean(user).getReturnStatus());}
        }

        if( null != action && action.equalsIgnoreCase("ClearAll")){
            basic.setStatus(iimsorRepoUpdate.cleanAll().getReturnStatus());
        }

        if(  null != action && null != user && action.equalsIgnoreCase("AddUser")){
            iimsorRepoUpdate.AddMe(user);
        }
        if(  null != action && null != user && action.equalsIgnoreCase("RemoveUser")){
            iimsorRepoUpdate.RemoveMe(user);
        }
        if(  null != action && action.equalsIgnoreCase("EnableAuditing")){

        }
        if(  null != action && action.equalsIgnoreCase("DisableAuditing")){

        }
        if(  null != action && action.equalsIgnoreCase("GetSelect")){

            if ( null != user && ! user.isEmpty()){
                Details.addAll( iimsorRepoOverview.getOVerviewforUser(user));
                }else{ Details.addAll( iimsorRepoOverview.getOVerviewforALL());
             }

            Collections.sort(Details, Collections.reverseOrder());

            String where = "", table = "", iditem = "";
            for (DETAILVIEW item : Details) {

                table = item.getTable();
                iditem =  String.valueOf(item.getId());
                where = showprimeList(iditem);

                if (table.length() > 0 && where.length() > 0) {

                    item.setOldVal("select * from " + table +" "+where);

                }
              //  item.setCol(getChanges(iditem)); -- Not happy with the response..

            }


        }
        basic.setDetails(Details);

        model.addAttribute("basicview", basic);
        return "overview";
    }


    @GetMapping("DBDetails")
    public String welcome(Model model,  HttpServletRequest request) {
        BASICVIEW basic = new BASICVIEW();
        String action =request.getParameter("_Action");
        String user = request.getParameter("user");
        List <DETAILVIEW> Details = new ArrayList<>();
        basic.setStatus("");
        basic.setUser(user);

        if( null != action && null != user && action.equalsIgnoreCase("Retrieve")){

            if ( null != user && ! user.isEmpty()) {
                Details.addAll(iimsorRepo.get1Details(user));
                Details.addAll(iimsorRepo.get2Details(user));
                Details.addAll(iimsorRepo.get3Details(user));
                Details.addAll(iimsorRepo.get4Details(user));
                Details.addAll(iimsorRepo.get5Details(user));
                Details.addAll(iimsorRepo.get6Details(user));
                Details.addAll(iimsorRepo.get7Details(user));
                Details.addAll(iimsorRepo.get8Details(user));
                Collections.sort(Details, Collections.reverseOrder());
            }else{
                Details.addAll( iimsorRepo.get1DetailsAll());
                Details.addAll( iimsorRepo.get2DetailsAll());
                Details.addAll( iimsorRepo.get3DetailsAll());
                Details.addAll( iimsorRepo.get4DetailsAll());
                Details.addAll( iimsorRepo.get5DetailsAll());
                Details.addAll( iimsorRepo.get6DetailsAll());
                Details.addAll( iimsorRepo.get7DetailsAll());
                Details.addAll( iimsorRepo.get8DetailsAll());
                Collections.sort(Details, Collections.reverseOrder());
            }
            }
        if( null != action && action.equalsIgnoreCase("RetrieveAll")){
            Details.addAll( iimsorRepo.get1DetailsAll());
            Details.addAll( iimsorRepo.get2DetailsAll());
            Details.addAll( iimsorRepo.get3DetailsAll());
            Details.addAll( iimsorRepo.get4DetailsAll());
            Details.addAll( iimsorRepo.get5DetailsAll());
            Details.addAll( iimsorRepo.get6DetailsAll());
            Details.addAll( iimsorRepo.get7DetailsAll());
            Details.addAll( iimsorRepo.get8DetailsAll());
            Collections.sort(Details, Collections.reverseOrder());
        }

        if(  null != action && null != user && action.equalsIgnoreCase("Clear")){
            if (user.isEmpty()) {    basic.setStatus("Please input requesting host' name.       ");}
            else{basic.setStatus(iimsorRepoUpdate.clean(user).getReturnStatus());}
        }


        if( null != action && action.equalsIgnoreCase("ClearAll")){
            basic.setStatus(iimsorRepoUpdate.cleanAll().getReturnStatus());
        }

        if(  null != action && null != user && action.equalsIgnoreCase("AddUser")){
            iimsorRepoUpdate.AddMe(user);
        }
        if(  null != action && null != user && action.equalsIgnoreCase("RemoveUser")){
            iimsorRepoUpdate.RemoveMe(user);
        }


        basic.setDetails(Details);

        model.addAttribute("basicview", basic);
        return "welcome";
    }

    @RequestMapping(value = "/Getid/{id}", method = RequestMethod.GET)
    public String showGuestList(Model model, @PathVariable("id") String id) {

        DETAILVIEW prime = new DETAILVIEW(id);


        prime.setCol("Key Identifier \""+showprimeList(id)+"\"");
        List <DETAILVIEW> Details = new ArrayList<>();
             Details.addAll( iimsorRepoOverview.get1Details(id));
        Details.addAll( iimsorRepoOverview.get2Details(id));
        Details.addAll( iimsorRepoOverview.get3Details(id));
        Details.addAll( iimsorRepoOverview.get4Details(id));
        Details.addAll( iimsorRepoOverview.get5Details(id));
        Details.addAll( iimsorRepoOverview.get6Details(id));
        Details.addAll( iimsorRepoOverview.get7Details(id));
       // Details.addAll( iimsorRepoOverview.get8Details(id));
        Details.addAll( iimsorRepoOverview.get8Details(id));
        Details.add(prime);
        Collections.sort(Details, Collections.reverseOrder());
        model.addAttribute("details", Details);

        return "frags :: resultsList";
    }

    @RequestMapping(value = "/Getprime/{id}", method = RequestMethod.GET)
    public String showprimeList(@PathVariable("id") String id) {

        List <PRIMEVIEW> Details = new ArrayList<>();

       Details.addAll(iimsorRepoOverview.get1prime(id));
        Details.addAll(iimsorRepoOverview.get2prime(id));
        Details.addAll(iimsorRepoOverview.get3prime(id));
        Details.addAll(iimsorRepoOverview.get4prime(id));
        Details.addAll(iimsorRepoOverview.get5prime(id));


        String where = "", val="";
        for (PRIMEVIEW item : Details) {
val=item.getVal();
if (null==val){val="";}
            if (val.length() > 0) {
                if (where.length()> 0 ) { where = where + " AND ";}
                where = where + val ;
            }

        }

        if (where.length()> 0 ) { where = "where " + where;}

        return where;
    }


    public String getChanges(String id) {

        List <DETAILVIEW> Details = new ArrayList<>();
        Details.addAll( iimsorRepoOverview.get1Details(id));
        Details.addAll( iimsorRepoOverview.get2Details(id));
        Details.addAll( iimsorRepoOverview.get3Details(id));
        Details.addAll( iimsorRepoOverview.get4Details(id));
        Details.addAll( iimsorRepoOverview.get5Details(id));
        Details.addAll( iimsorRepoOverview.get6Details(id));
        Details.addAll( iimsorRepoOverview.get7Details(id));
        Details.addAll( iimsorRepoOverview.get8Details(id));
        //Details.addAll( iimsorRepoOverview.get8Details(id));
        Collections.sort(Details, Collections.reverseOrder());


        String changes = "", col="", newval="",oldval="";
        for (DETAILVIEW item : Details) {
          col =  item.getCol();

            oldval = item.getOldVal();
            newval =item.getNewVal();
            if (null==col){col="";}
            if (null==oldval){oldval="";}
            if (null==newval){newval="";}
            if (col.length() > 0) {
                changes = changes+col+" :: ";
                if (oldval.length() > 0) {
                    changes = changes+oldval+" = > " ;
                    if (newval.length() > 0) {
                        changes = changes+newval;
                    }

                }
                //changes = changes+ "<br/>";

            }

        }


        return changes;
    }




/*
    @RequestMapping(value = "/Changes", method = RequestMethod.GET)
    public List<CHANGES>  Changes(@RequestHeader(value="user") String user) {
               return iimsorRepo.getIIMSOR(user);
    }

*//*    @RequestMapping(value = "/Details", method = RequestMethod.GET, produces = "text/csv")
    public String Details(@RequestParam(value="id") String id) {

        String outputString = "";
        List<DETAILVIEW> output = iimsorRepo.getDetails5(id);
        for (DETAILVIEW item : output) {
            outputString = item.toString() + "\n";
        }*//*





    public String getuser( @ModelAttribute("user") String user) {

        //return iimsorRepo.RemoveMe(user);
        return user;

    }



    //  @RequestMapping(value = "/Details", method = RequestMethod.GET )
        @GetMapping("/Details1")
        public String Details1(@RequestParam(value="id") String id, HttpServletRequest request, Model model) {



         //    List<DETAILVIEW> detailviews = iimsorRepo.getprettyglobal();
           *//* detailviews.addAll(iimsorRepo.getDetails2(id));
            detailviews.addAll(iimsorRepo.getDetails3(id));
            detailviews.addAll(iimsorRepo.getDetails4(id));
            detailviews.addAll(iimsorRepo.getDetails5(id));
            detailviews.addAll(iimsorRepo.getDetails6(id));
            detailviews.addAll(iimsorRepo.getDetails7(id));
            detailviews.addAll(iimsorRepo.getDetails8(id));*//*
          //  detailviews.get(0).getString()



        //    StringBuilder sb  = new StringBuilder();
       //     for (DETAILVIEW item : detailviews) {
//sb.append(item.getString())             ;
       //         sb.append('\n');
           // }
          //  return sb.toString();
            return  "dbwatch";
        }

    @RequestMapping(value = "/Details/All", method = RequestMethod.GET )
    public List<DETAILVIEW> DetailsAll(@RequestParam(value="id") String id) {
        List<DETAILVIEW> detailviews = iimsorRepo.getDetails1(id);
        detailviews.addAll(iimsorRepo.getDetails2(id));
        detailviews.addAll(iimsorRepo.getDetails3(id));
        detailviews.addAll(iimsorRepo.getDetails4(id));
        detailviews.addAll(iimsorRepo.getDetails5(id));
        detailviews.addAll(iimsorRepo.getDetails6(id));
        detailviews.addAll(iimsorRepo.getDetails7(id));
        detailviews.addAll(iimsorRepo.getDetails8(id));
        return detailviews;
    }


    @GetMapping("/Clean")
    //@RequestMapping(value = "/Clean", method = RequestMethod.POST)
    public String Clean() {
        // iimsorRepo.clean(user);
        return "clean";
    }

    @RequestMapping(value = "/AddMe", method = RequestMethod.POST)
  //  public String AddMe(@RequestHeader(value="user") String user) {
    public String AddMe() {
       // return iimsorRepo.AddMe(user);
        return  "dbwatch";
    }





    @RequestMapping(value = "/Details1", method = RequestMethod.GET)
    public List<DETAILVIEW>  Details1(@RequestParam(value="id") String id) {
        return iimsorRepo.getDetails1(id);
    }

    @RequestMapping(value = "/Details2", method = RequestMethod.GET)
    public List<DETAILVIEW>  Details2(@RequestParam(value="id") String id) {
        return iimsorRepo.getDetails2(id);
    }
    @RequestMapping(value = "/Details3", method = RequestMethod.GET)
    public List<DETAILVIEW>  Details3(@RequestParam(value="id") String id) {
        return iimsorRepo.getDetails3(id);
    }
    @RequestMapping(value = "/Details4", method = RequestMethod.GET)
    public List<DETAILVIEW>  Details4(@RequestParam(value="id") String id) {
        return iimsorRepo.getDetails4(id);
    }
    @RequestMapping(value = "/Details5", method = RequestMethod.GET)
    public List<DETAILVIEW>  Details5(@RequestParam(value="id") String id) {
        return iimsorRepo.getDetails5(id);
    }
    @RequestMapping(value = "/Details6", method = RequestMethod.GET)
    public List<DETAILVIEW>  Details6(@RequestParam(value="id") String id) {
        return iimsorRepo.getDetails6(id);
    }
    @RequestMapping(value = "/Details7", method = RequestMethod.GET)
    public List<DETAILVIEW>  Details7(@RequestParam(value="id") String id) {
        return iimsorRepo.getDetails7(id);
    }
    @RequestMapping(value = "/Details8", method = RequestMethod.GET)
    public List<DETAILVIEW>  Details8(@RequestParam(value="id") String id) {
        return iimsorRepo.getDetails8(id);
    }*/

}
