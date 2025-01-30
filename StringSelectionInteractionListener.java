package Commands;

import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;

import java.util.*;
import java.util.stream.Collectors;

public class StringSelectionInteractionListener extends ListenerAdapter {

    @Override
    public void onStringSelectInteraction(StringSelectInteractionEvent event){
        //String testingString = event.getValues().toString();

       List<SelectOption> selectionArray = event.getInteraction().getSelectedOptions();
       int arraysize = selectionArray.size(); //casuse arrays start at 0
       ArrayList<String> warbondList = new ArrayList<>();

        for (int i = 0; i < arraysize; i++) {
            warbondList.add(event.getInteraction().getValues().get(i));
        }

        String enemyType = enemyType();
        String difficulty = diff();
        String primaryWeapon = primaryWeapon(warbondList);
        String secondaryWeapon = secWeapon(warbondList);
        String throwable = throwable(warbondList);
        String armorLevel = armorLevel();
        String armorPassive = armorPassive(warbondList,armorLevel);

        event.reply("You Selected the following warbonds Helldiver: "+ warbondList.toString().replace("[","").replace("]","")
                + "Hello Helldiver, General Brash has demanded that you use the following on your next `" + operation(enemyType) + "` operation against the `" + enemyType + "`\n" +
                "Difficulty: `" + difficulty  + "`\n" +
                "Your weapon is: `" + primaryWeapon  + "`\n" +
                "Your secondary is: `" + secondaryWeapon + "`\n" +
                "Your throwable is: `" + throwable + "`\n" +
                "Armor: `" + armorLevel + "` armor with the `" + armorPassive + "` Passive.\n" +
                "Your stratagems will be the following:\n" + stratagems(warbondList) + "\n" +
                "Your Booster is: \n`" + hellpodOpt(warbondList) +"`\n" +
                randomPhrase()).setEphemeral(true).queue();
    }

    public static String primaryWeapon(ArrayList<String> warbondList){
        ArrayList<String> primaryList = new ArrayList<>();
        Random randomprimary = new Random();
        primaryList.add("AR-23 Liberator");
        primaryList.add("Constituion");

        if(warbondList.contains("Helldivers Mobilize")){
            primaryList.add("Ar-23P Liberator Penetrator");
            primaryList.add("R-63 Dilligence");
            primaryList.add("R-63CS Dilligence Counter Sniper");
            primaryList.add("Smg-37 Defender");
            primaryList.add("Sg-8 Punisher");
            primaryList.add("Sg-8S Slugger");
            primaryList.add("Sg-255 Breaker");
            primaryList.add("Sg-225SP Breaker Spray & Pray");
            primaryList.add("Las-5 Scythe");
            primaryList.add("Plas-1 Scorcher");

        }
        if(warbondList.contains("Steeled Veterans")){
            primaryList.add("Ar-23C- Liberator Concussive");
            primaryList.add("Jar-5 Dominator");
            primaryList.add("Sg-2251E Breaker Incendiary");
        }
        if(warbondList.contains("Cutting Edge")){
            primaryList.add("Arc-12 Blitzer");
            primaryList.add("Las-16 Sickle");
            primaryList.add("SG-8P Punisher Plasma");
        }
        if(warbondList.contains("Democratic Detonation")){
            primaryList.add("Br-14 Adjudicator");
            primaryList.add("Cb Exploding Crossbow");
            primaryList.add("R-36 Eruiptor");
        }
        if(warbondList.contains("Polar Patriots")){
            primaryList.add("Ar-61 Tenderizer");
            primaryList.add("Smg-72 Pummeler");
            primaryList.add("Plas-101 Purifier");
        }
        if(warbondList.contains("Viper Commandos")){
            primaryList.add("Ar-23A Liberator Carbine");
        }
        if(warbondList.contains("Freedom's Flame")){
            primaryList.add("Sg-451 Cookout");
            primaryList.add("Flam-66 Torcher");
        }
        if(warbondList.contains("Truth Enforcers")){
            primaryList.add("Smg-32 Reprimand");
            primaryList.add("Sg-20 Halt");
        }
        if(warbondList.contains("Killzone")){
            primaryList.add("StA-52 Assault Rifle");
            primaryList.add("PLAS-39 Accelerator Rifle");
            primaryList.add("Sta-11 SMG");
        }
        if(warbondList.contains("Pre-Order")){
            primaryList.add("MP-98 Knight");
        }
        String primary = primaryList.get(randomprimary.nextInt(primaryList.size()));
        return primary;
    }
    public static String secWeapon(ArrayList<String> warbondList){
        ArrayList<String> secondaryList = new ArrayList<>();
        Random randomsecwep = new Random();

        secondaryList.add("P-2 Peacemaker");

        if(warbondList.contains("Helldivers Mobilize")){
            secondaryList.add("P-19 Redeemer"); //mobilzie
        }
        if(warbondList.contains("Steeled Veterans")){
            secondaryList.add("P-4 Senator"); //steel
        }
        if(warbondList.contains("Cutting Edge")){
            secondaryList.add("Las-7 Dagger"); // cutting edge
        }
        if(warbondList.contains("Democratic Detonation")){
            secondaryList.add("Gp-31 Grenade Pistol"); //detonation
        }
        if(warbondList.contains("Polar Patriots")){
            secondaryList.add("P-2 P-113 Verdict"); //polar
        }
        if(warbondList.contains("Viper Commandos")){
            secondaryList.add("sg-22 Bushwhacker"); //viper
        }
        if(warbondList.contains("Freedom's Flame")){
            secondaryList.add("P-72 Crisper"); // Flame
        }
        if(warbondList.contains("Chemical Agents")){
            secondaryList.add("P-11 Stim Pistol"); //checmical
        }
        if(warbondList.contains("Truth Enforcers")){
            secondaryList.add("Plas-15 Loyalist"); //truth

        }
        if(warbondList.contains("Urban Legends")){
            secondaryList.add("Cqc-19 stun lance"); //Urban
        }
        if(warbondList.contains("Super Store")){
            secondaryList.add("cqc-30 Stun Baton"); //super store
        }

        String secwep = secondaryList.get(randomsecwep.nextInt(secondaryList.size()));
        return secwep;
    }
    public static String throwable(ArrayList<String> warbondList){

        Random randomthrown = new Random();
        ArrayList<String> throwableList = new ArrayList<>();

        throwableList.add("G-12 High Explosive");

        if(warbondList.contains("Helldivers Mobilize")){
           throwableList.add("G-6 Frag");
           throwableList.add("G-16 Impact");
           throwableList.add("G-3 Smoke");
        }
        if(warbondList.contains("Steeled Veterans")){
            throwableList.add("G-10 Incendiary");
        }
        if(warbondList.contains("Polar Patriots")){
            throwableList.add("G-13 Incendiary");
        }
        if(warbondList.contains("Cutting Edge")){
            throwableList.add("G-23 Stun");
        }
        if(warbondList.contains("Chemical Agents")){
            throwableList.add("G-4 Gas");
        }
        if(warbondList.contains("Democratic Detonation")){
            throwableList.add("6-123 Thermite");
        }
        if(warbondList.contains("Viper Commandos")){
            throwableList.add("K-2 Throwing Knife");
        }

        String thrown = throwableList.get(randomthrown.nextInt(throwableList.size()));

        return thrown;
    }
    public static String armorLevel(){
        String armorLevel = "";
        Random armortyperan = new Random();
        int armorLevelInt = armortyperan.nextInt(3-1 + 1) +1;
        switch (armorLevelInt) {
            case 1-> armorLevel = "Light";
            case 2-> armorLevel = "Medium";
            case 3-> armorLevel = "Heavy";
        }

        return armorLevel;
    }
    public static String armorPassive(ArrayList<String> warbondList,String armorLevel){
        ArrayList<String> armorPassiveList = new ArrayList<>();
        ArrayList<String> passivesWithOutDups = new ArrayList<>();
        Random armorpassran = new Random();

        if(armorLevel.equals("Light")){
           if(warbondList.contains("Chemical Agents")){armorPassiveList.add("Advanced Filtration");}
           if(warbondList.contains("Cutting Edge")){armorPassiveList.add("Electrical Conduit");}
           if(warbondList.contains("Democratic Detonation")){armorPassiveList.add("Engineering Kit");}
           if(warbondList.contains("Freedom's Flame")){armorPassiveList.add("Inflammable");}
           if(warbondList.contains("Helldivers Mobilize")){armorPassiveList.add("Scout");}
           if(warbondList.contains("Killzone")){armorPassiveList.add("Acclimated");}
           if(warbondList.contains("Polar Patriots")){armorPassiveList.add("Scout");}
           if(warbondList.contains("Pre-Order")){}
           if(warbondList.contains("Super Store")){
               armorPassiveList.add("Servo-Assisted");
               armorPassiveList.add("Engineering Kit");
               armorPassiveList.add("Fortified");
               armorPassiveList.add("Extra Padding");
               armorPassiveList.add("Med-Kit");
           }
           if(warbondList.contains("Steeled Veterans")){}
           if(warbondList.contains("Truth Enforcers")){armorPassiveList.add("Unflinching");}
           if(warbondList.contains("Urban Legends")){armorPassiveList.add("Siege-Ready");}
           if(warbondList.contains("Viper Commandos")){armorPassiveList.add("Peak Physique");}


        }else if (armorLevel.equals("Medium")){
            armorPassiveList.add("Extra Padding"); //starter
            if(warbondList.contains("Chemical Agents")){armorPassiveList.add("Advanced Filtration");}
            if(warbondList.contains("Cutting Edge")){armorPassiveList.add("Electrical Conduit");}
            if(warbondList.contains("Democratic Detonation")){armorPassiveList.add("Engineering Kit");}
            if(warbondList.contains("Freedom's Flame")){armorPassiveList.add("Inflammable");}
            if(warbondList.contains("Helldivers Mobilize")){
                armorPassiveList.add("Scout");
                armorPassiveList.add("Engineering Kit");
                armorPassiveList.add("Med-Kit");
                armorPassiveList.add("Democracy Protects");
            }
            if(warbondList.contains("Killzone")){armorPassiveList.add("Acclimated");}
            if(warbondList.contains("Polar Patriots")){armorPassiveList.add("Scout");}
            if(warbondList.contains("Pre-Order")){
                armorPassiveList.add("Extra Padding");
                armorPassiveList.add("Democracy Protects");
            }
            if(warbondList.contains("Super Store")){
                armorPassiveList.add("Acclimated");
                armorPassiveList.add("Engineering Kit");
                armorPassiveList.add("Fortified");
                armorPassiveList.add("Med-Kit");
                armorPassiveList.add("Extra Padding");
                armorPassiveList.add("Peak Physique");
                armorPassiveList.add("Advanced Filtration");
            }
            if(warbondList.contains("Steeled Veterans")){ armorPassiveList.add("Servo-Assisted");}
            if(warbondList.contains("Truth Enforcers")){armorPassiveList.add("Unflinching");}
            if(warbondList.contains("Urban Legends")){}
            if(warbondList.contains("Viper Commandos")){}

        } else if (armorLevel.equals("Heavy")) {

            if(warbondList.contains("Democratic Detonation")){armorPassiveList.add("Fortified");}
            if(warbondList.contains("Helldivers Mobilize")){armorPassiveList.add("Fortified");}
            if(warbondList.contains("Killzone")){armorPassiveList.add("Acclimated");}
            if(warbondList.contains("Polar Patriots")){
                armorPassiveList.add("Servo-Assisted");
                armorPassiveList.add("Fortified");
            }
            if(warbondList.contains("Pre-Order")){armorPassiveList.add("Servo-Assisted");}
            if(warbondList.contains("Super Store")){
                armorPassiveList.add("Engineering Kit");
                armorPassiveList.add("Fortified");
                armorPassiveList.add("Med-Kit");
                armorPassiveList.add("Extra Padding");
                armorPassiveList.add("Advanced Filtration");
                armorPassiveList.add("Inflammable");
                armorPassiveList.add("Siege-Ready");
                armorPassiveList.add("Servo-Assisted");
            }
            if(warbondList.contains("Steeled Veterans")){ armorPassiveList.add("Servo-Assisted");}
            if(warbondList.contains("Truth Enforcers")){}
            if(warbondList.contains("Urban Legends")){armorPassiveList.add("Siege-Ready");}
            if(warbondList.contains("Viper Commandos")){}

        }

        passivesWithOutDups = (ArrayList<String>) armorPassiveList.stream().distinct().collect(Collectors.toList());
        int armorPassiveInt = armorpassran.nextInt(passivesWithOutDups.size());;
        System.out.println(armorPassiveInt);
        System.out.println(passivesWithOutDups);

        return passivesWithOutDups.get(armorPassiveInt);
    }
    public static String stratagems(ArrayList<String> warbondList){
        List<String> stratagems = new ArrayList<>();
        List<String> loadedStatsagems = new ArrayList<>();

        List<Integer> stratagemnumbers = new ArrayList<>();
        Random stratagemran = new Random();

        stratagems.add("`MG-43 Machine Gun`\n");
        stratagems.add("`APW-1 Anti-Materiel Rifle`\n");
        stratagems.add("`M-105 Stalwart`\n");
        stratagems.add("`EAT-17 Expendable Anti-Tank`\n");
        stratagems.add("`GR-8 Recoilless Rifle`\n");
        stratagems.add("`FLAM-40 Flamethrower`\n");
        stratagems.add("`AC-8 Autocannon`\n");
        stratagems.add("`MG-206 Heavy Machine Gun`\n");
        stratagems.add("`RL-77 Airburst Rocket Launcher`\n");
        stratagems.add("`MLS-4X Commando`\n");
        stratagems.add("`RS-422 Railgun`\n");
        stratagems.add("`FAF-14 Spear`\n");
        stratagems.add("`StA-X3 W.A.S.P. Launcher`\n");
        stratagems.add("`Orbital Gatling Barrage`\n");
        stratagems.add("`Orbital Airburst Strike`\n");
        stratagems.add("`Orbital 120mm HE Barrage`\n");
        stratagems.add("`Orbital 380mm HE Barrage`\n");
        stratagems.add("`Orbital Walking Barrage`\n");
        stratagems.add("`Orbital Laser`\n");
        stratagems.add("`Orbital Napalm Barrage`\n");
        stratagems.add("`Orbital Railcannon Strike`\n");
        stratagems.add("`Eagle Strafing Run`\n");
        stratagems.add("`Eagle Airstrike`\n");
        stratagems.add("`Eagle Cluster Bomb`\n");
        stratagems.add("`Eagle Napalm Airstrike`\n");
        stratagems.add("`LIFT-850 Jump Pack`\n");
        stratagems.add("`Eagle Smoke Strike`\n");
        stratagems.add("`Eagle 110mm Rocket Pods`\n");
        stratagems.add("`Eagle 500kg Bomb`\n");
        stratagems.add("`M-102 Fast Recon Vehicle`\n");
        stratagems.add("`Orbital Precision Strike`\n");
        stratagems.add("`Orbital Gas Strike`\n");
        stratagems.add("`Orbital EMS Strike`\n");
        stratagems.add("`Orbital Smoke Strike`\n");
        stratagems.add("`E/MG-101 HMG Emplacement`\n");
        stratagems.add("`FX-12 Shield Generator Relay`\n");
        stratagems.add("`A/ARC-3 Tesla Tower`\n");
        stratagems.add("`MD-6 Anti-Personnel Minefield`\n");
        stratagems.add("`B-1 Supply Pack`\n");
        stratagems.add("`GL-21 Grenade Launcher`\n");
        stratagems.add("`LAS-98 Laser Cannon`\n");
        stratagems.add("`MD-I4 Incendiary Mines`\n");
        stratagems.add("`AX/LAS-5 Guard Dog Rover`\n");
        stratagems.add("`SH-20 Ballistic Shield Backpack`\n");
        stratagems.add("`ARC-3 Arc Thrower`\n");
        stratagems.add("`MD-17 Anti-Tank Mines`\n");
        stratagems.add("`LAS-99 Quasar Cannon`\n");
        stratagems.add("`SH-32 Shield Generator Pack`\n");
      //stratagems.add("`MD-8 Gas Mines`\n");
        stratagems.add("`A/MG-43 Machine Gun Sentry`\n");
        stratagems.add("`A/G-16 Gatling Sentry`\n");
        stratagems.add("`A/M-12 Mortar Sentry`\n");
        stratagems.add("`AX/AR-23 Guard Dog`\n");
        stratagems.add("`A/AC-8 Autocannon Sentry`\n");
        stratagems.add("`A/MLS-4X Rocket Sentry`\n");
        stratagems.add("`A/M-23 EMS Mortar Sentry`\n");
        stratagems.add("`EXO-45 Patriot Exosuit`\n");
        stratagems.add("`EXO-49 Emancipator Exosuit`\n");

        if(warbondList.contains("Chemical Agents")){
            stratagems.add("`AX/TX-13 Guard Dog Dog Breath`\n");
            stratagems.add("`TX-41 Sterilizer`\n");
        }
        if(warbondList.contains("Urban Legends")) {
            stratagems.add("`SH-51 Directional Shield`\n");
            stratagems.add("`E/AT-12 Anti-Tank Emplacement`\n");
            stratagems.add("`A/FLAM-40 Flame Sentry`\n");
        }
        int exo45Location = stratagems.indexOf("`EXO-45 Patriot Exosuit`\n");
        int exo49Location = stratagems.indexOf("`EXO-49 Emancipator Exosuit`\n");


        for (int i = 0; i < 4; i++) {
            int stratagemInt = stratagemran.nextInt(stratagems.size());
            if(!stratagemnumbers.contains(stratagemInt) || (stratagemInt == exo45Location || stratagemInt == exo49Location) && (stratagemnumbers.contains(exo45Location) || stratagemnumbers.contains(exo49Location))){stratagemnumbers.add(stratagemInt) ;}
            else i=i-1;
        }


        for (int number : stratagemnumbers){
            loadedStatsagems.add(stratagems.get(number));

        }

        return String.valueOf(loadedStatsagems.get(0) + loadedStatsagems.get(1) + loadedStatsagems.get(2) + loadedStatsagems.get(3));
    }
    public static String hellpodOpt(ArrayList<String> warbondList){
        List<Integer> hellpodoptnumbers = new ArrayList<>();
        ArrayList<String> hellPodList = new ArrayList<>();
        List<String> hellpodOpts = new ArrayList<>();

        if(warbondList.contains("Helldivers Mobilize")){
            hellPodList.add("Hellpod Space Optimization");
            hellPodList.add("Vitality Enhancement");
            hellPodList.add("UAV Recon Booster");
            hellPodList.add("Stamina Enhancement");
            hellPodList.add("Muscle Enhancement");
            hellPodList.add("Increased Reinforcement Budget");
        }
        if(warbondList.contains("Steeled Veterans")){hellPodList.add("Flexible Reinforcement Budget");}
        if(warbondList.contains("Polar Patriots")){warbondList.add("Motivational Shocks");}
        if(warbondList.contains("Cutting Edge")){hellPodList.add("Localization Confusion");}
        if(warbondList.contains("Democratic Detonation")){hellPodList.add("Expert Extraction Pilot");}
        if(warbondList.contains("Viper Commandos")){hellPodList.add("Experimental Infusion");}
        if(warbondList.contains("Freedom's Flame")){hellPodList.add("Firebomb Hellpods");}
        if(warbondList.contains("Truth Enforcers")){hellPodList.add("Dead Sprint");}
        if(warbondList.contains("Urban Legends")){hellPodList.add("Armed Resupply Pods");}

        Random hellpodOptran = new Random();
        for (int i = 0; i < 4; i++) {

            int hellpodoptagemInt = hellpodOptran.nextInt(hellPodList.size());
            if(!hellpodoptnumbers.contains(hellpodoptagemInt)){hellpodoptnumbers.add(hellpodoptagemInt);}
            else i=i-1;

        }
        for (int number : hellpodoptnumbers){
               hellpodOpts.add(hellPodList.get(number));
        }

        return "1. " + hellpodOpts.get(0) + "\n" +  "2. " + hellpodOpts.get(1) + "\n" + "3. " + hellpodOpts.get(2) + "\n" + "4. " + hellpodOpts.get(3);
    }

    public static String enemyType(){
        String enemytype = "";
        Random enemyran = new Random();
        int emenyInt = enemyran.nextInt(3 -1 +1) +1;

        switch (emenyInt){
            case 1-> enemytype = "Terminids";
            case 2-> enemytype = "Automatons";
            case 3-> enemytype = "Illuminate";
        }

        return  enemytype;
    }
    public static String operation(String enemy){
        String operation = "";
        Random operationran = new Random();

        if(enemy.equals("Terminids") || enemy.equals("Automatons")){
            int operInt = operationran.nextInt(2 - 1 + 1) +1;
            switch (operInt){
                case 1 -> operation = "Peacekeeping";
                case 2 -> operation = "Defend Planet";
            }
        } else {operation = "Defend Planet";}

        return operation;
    }
    public static String diff(){
        String diff = "";
        Random diffran = new Random();
        int diffInt = diffran.nextInt(7 -1 +1) +1;

        switch (diffInt){
            case 1-> diff = "Challenging";
            case 2-> diff = "Hard";
            case 3-> diff = "Extreme";
            case 4-> diff = "Sui Mission";
            case 5-> diff = "Impossible";
            case 6-> diff = "Helldive";
            case 7-> diff = "Super Helldive";
        }
        return diff;
    }
    public static String randomPhrase(){
        String phrase = "";

        Random phraseran = new Random();
        int phrasefranInt = phraseran.nextInt(7 -1 +1) +1;

        switch (phrasefranInt) {
            case 1 -> phrase = "Now go distribute some managed democracy!";
            case 2 -> phrase = "Show them what democracy's arsenal looks like";
            case 3 -> phrase = "Make sure to show up alive, for your next assignment helldiver";
            case 4 -> phrase = "The ministry of science looks forward to your results";
            case 5 -> phrase = "NOW DIVE! DIVE! DIVE! HELLDIVER!!!";
            case 6 -> phrase = "Your victory is assured with this load out";
            case 7 -> phrase = "The only thing more powerful than this is democracy";

        }
        return phrase;
    }

}
