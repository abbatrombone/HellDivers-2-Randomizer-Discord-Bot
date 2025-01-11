package Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLoadOut extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("randomloadout")) {

            String enemyType = enemyType();
            String difficulty = diff();
            String primaryWeapon = primaryWeapon();
            String secondaryWeapon = secWeapon();
            String throwable = throwable();
            String armorLevel = armorLevel();
            String armorPassive = armorPassive(armorLevel);

            event.reply("Hello Helldiver, General Brash has demanded that you use the following on your next `" + operation(enemyType) + "` operation against the " + enemyType + "\n" +
                    "Difficulty: `" + difficulty  + "`\n" +
                    "Your weapon is: `" + primaryWeapon  + "`\n" +
                    "Your secondary is: `" + secondaryWeapon + "`\n" +
                    "Your throwable is: `" + throwable + "`\n" +
                    "Armor: `" + armorLevel + "` armor with the `" + armorPassive + "` Passive. Should you not have an armor passive like that use this one: `" + backupArmorPassive() + "`\n" +
                    "Your stratagems will be the following:\n" + stratagems() + "\n" +
                    "Your Booster is: \n`" + hellpodOpt() +"`\n" +
                    randomPhrase()
            ).queue();
        }
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
    public static String armorPassive(String armorLevel){
        String passive = "";
        Random armorpassran = new Random();
        int armorPassiveInt = armorpassran.nextInt(13 -1 + 1) +1;

        if(armorLevel.equals("Light")){
            switch (armorPassiveInt) {
                case 1  -> passive = "Acclimated";
                case 2  -> passive = "Advanced Filtration";
                case 3  -> passive = "Electrical Conduit";
                case 4  -> passive = "Engineering Kit";
                case 5  -> passive = "Extra Padding";
                case 6  -> passive = "Fortified";
                case 7  -> passive = "Inflammable";
                case 8  -> passive = "Med-Kit";
                case 9  -> passive = "Peak Physique";
                case 10 -> passive = "Scout";
                case 11 -> passive = "Servo-Assisted";
                case 12 -> passive = "Siege-Ready";
                case 13 -> passive = "Unflinching";
            }
        }else if (armorLevel.equals("Medium")){
            switch (armorPassiveInt) {
                case 1  -> passive = "Extra Padding";
                case 2  -> passive = "Democracy Protects";
                case 3  -> passive = "Med-Kit";
                case 4  -> passive = "Engineering Kit";
                case 5  -> passive = "Scout";
                case 6  -> passive = "Servo-Assisted";
                case 7  -> passive = "Fortified";
                case 8  -> passive = "Electrical Conduit";
                case 9  -> passive = "Peak Physique";
                case 10 -> passive = "Inflammable";
                case 11 -> passive = "Advanced Filtration";
                case 12 -> passive = "Unflinching";
                case 13 -> passive = "Acclimated";
            }
        } else if (armorLevel.equals("Heavy")) {
            switch (armorPassiveInt) {
                case 1,10 -> passive = "Servo-Assisted";
                case 2,11 -> passive = "Fortified";
                case 3    -> passive = "Extra Padding";
                case 4    -> passive = "Med-Kit";
                case 5    -> passive = "Engineering Kit";
                case 6,12 -> passive = "Peak Physique";
                case 7    -> passive = "Inflammable";
                case 8    -> passive = "Advanced Filtration";
                case 9,13 -> passive = "Siege-Ready";
            }
        }

        return passive;
    }

    public static String backupArmorPassive(){
        String backuppassive = "";
        Random bckarmorpassran = new Random();
        int armorPassiveInt = bckarmorpassran.nextInt(6 -1 + 1) +1;
        switch (armorPassiveInt){
            case 1-> backuppassive= "Engineering Kit";
            case 2-> backuppassive= "Extra Padding";
            case 3-> backuppassive= "Inflammable";
            case 4-> backuppassive= "Med-Kit";
            case 5-> backuppassive= "Peak Physique";
            case 6-> backuppassive = "Servo-Assisted";
        }
        return backuppassive;
    }
    public static String primaryWeapon(){
        String primary = "";
        Random randomprimary = new Random();
        int primaryInt = randomprimary.nextInt(33 -1 + 1) +1;
        switch (primaryInt){
            case 1 -> primary = "Ar-23 Liberator";
            case 2 -> primary = "Ar-23P Liberator Penetrator";
            case 3 -> primary = "Ar-23C- Liberator Concussive";
            case 4 -> primary = "StA-52 Assault Rifle";
            case 5 -> primary = "Ar-23A Liberator Carbine";
            case 6 -> primary = "Ar-61 Tenderizer";
            case 7 -> primary = "Br-14 Adjudicator";
            case 8 -> primary = "Constituion";
            case 9 -> primary = "R-63 Dilligence";
            case 10-> primary = "R-63CS Dilligence Counter Sniper";
            case 11-> primary = "PLAS-39 Accelerator Rifle";
            case 12-> primary = "MP-98 Knight";
            case 13-> primary = "Sta-11 SMG";
            case 14-> primary = "Smg-32 Reprimand";
            case 15-> primary = "Smg-37 Defender";
            case 16-> primary = "Smg-72 Pummeler";
            case 17-> primary = "Sg-8 Punisher";
            case 18-> primary = "Sg-8S Slugger";
            case 19-> primary = "Sg-20 Halt";
            case 20-> primary = "Sg-451 Cookout";
            case 21-> primary = "Sg-255 Breaker";
            case 22-> primary = "Sg-225SP Breaker Spray & Pray";
            case 23-> primary = "Sg-2251E Breaker Incendiary";
            case 24-> primary = "Cb Exploding Crossbow";
            case 25-> primary = "R-36 Eruiptor";
            case 26-> primary = "SG-8P Punisher Plasma";
            case 27-> primary = "Arc-12 Blitzer";
            case 28-> primary = "Las-5 Scythe";
            case 29-> primary = "Las-16 Sickle";
            case 30-> primary = "Plas-1 Scorcher";
            case 31-> primary = "Plas-101 Purifier";
            case 32-> primary = "Flam-66 Torcher";
            case 33-> primary = "Jar-5 Dominator";

        }
        return primary;
    }
    public static String secWeapon(){
        String secwep = "";
        Random randomsecwep = new Random();
        int secInt = randomsecwep.nextInt(12 -1 + 1) +1;

        switch (secInt){
            case 1  -> secwep = "P-2 Peacemaker";
            case 2  -> secwep = "P-19 Redeemer";
            case 3  -> secwep = "P-2 P-113 Verdict";
            case 4  -> secwep = "P-4 Senator";
            case 5  -> secwep = "Cqc-19 stun lance";
            case 6  -> secwep = "cqc-30 Stun Baton";
            case 7  -> secwep = "P-11 Stim Pistol";
            case 8  -> secwep = "sg-22 Bushwhacker";
            case 9  -> secwep = "P-72 Crisper";
            case 10 -> secwep = "Gp-31 Grenade Pistol";
            case 11 -> secwep = "Las-7 Dagger";
            case 12 -> secwep = "Plas-15 Loyalist";

        }
        return secwep;
    }

    public static String throwable(){
        String thrown = "";
        Random randomthrown = new Random();
        int thrownInt = randomthrown.nextInt(10 -1 + 1) +1;

        switch (thrownInt){
            case 1 -> thrown = "G-6 Frag";
            case 2 -> thrown = "G-12 High Explosive";
            case 3 -> thrown = "G-10 Incendiary";
            case 4 -> thrown = "G-16 Impact";
            case 5 -> thrown = "G-13 Incendiary";
            case 6 -> thrown = "G-23 Stun";
            case 7 -> thrown = "G-4 Gas";
            case 8 -> thrown = "G-3 Smoke";
            case 9 -> thrown = "6-123 Thermite";
            case 10-> thrown = "K-2 Throwing Knife";

        }
        return thrown;
    }
    public static String stratagems(){
        List<String> stratagems = new ArrayList<>();
        List<Integer> stratagemnumbers = new ArrayList<>();
        Random stratagemran = new Random();

        for (int i = 0; i < 4; i++) {
            int stratagemInt = stratagemran.nextInt(63 -1 + 1) +1;
            if(!stratagemnumbers.contains(stratagemInt) || (stratagemInt == 57 || stratagemInt == 58) && (stratagemnumbers.contains(58) || stratagemnumbers.contains(57))){stratagemnumbers.add(stratagemInt) ;}
            else i=i-1;
        }

        for (int number : stratagemnumbers){
            switch (number){
                case 1 -> stratagems.add("`MG-43 Machine Gun`\n");
                case 2  ->stratagems.add("`APW-1 Anti-Materiel Rifle`\n");
                case 3  ->stratagems.add("`M-105 Stalwart`\n");
                case 4  ->stratagems.add("`EAT-17 Expendable Anti-Tank`\n");
                case 5  ->stratagems.add("`GR-8 Recoilless Rifle`\n");
                case 6  ->stratagems.add("`FLAM-40 Flamethrower`\n");
                case 7  ->stratagems.add("`AC-8 Autocannon`\n");
                case 8  ->stratagems.add("`MG-206 Heavy Machine Gun`\n");
                case 9  ->stratagems.add("`RL-77 Airburst Rocket Launcher`\n");
                case 10 ->stratagems.add("`MLS-4X Commando`\n");
                case 11 ->stratagems.add("`RS-422 Railgun`\n");
                case 12 ->stratagems.add("`FAF-14 Spear`\n");
                case 13 ->stratagems.add("`StA-X3 W.A.S.P. Launcher`\n");
                case 14 ->stratagems.add("`Orbital Gatling Barrage`\n");
                case 15 ->stratagems.add("`Orbital Airburst Strike`\n");
                case 16 ->stratagems.add("`Orbital 120mm HE Barrage`\n");
                case 17 ->stratagems.add("`Orbital 380mm HE Barrage`\n");
                case 18 ->stratagems.add("`Orbital Walking Barrage`\n");
                case 19 ->stratagems.add("`Orbital Laser`\n");
                case 20 ->stratagems.add("`Orbital Napalm Barrage`\n");
                case 21 ->stratagems.add("`Orbital Railcannon Strike`\n");
                case 22 ->stratagems.add("`Eagle Strafing Run`\n");
                case 23 ->stratagems.add("`Eagle Airstrike`\n");
                case 24 ->stratagems.add("`Eagle Cluster Bomb`\n");
                case 25 ->stratagems.add("`Eagle Napalm Airstrike`\n");
                case 26 ->stratagems.add("`LIFT-850 Jump Pack`\n");
                case 27 ->stratagems.add("`Eagle Smoke Strike`\n");
                case 28 ->stratagems.add("`Eagle 110mm Rocket Pods`\n");
                case 29 ->stratagems.add("`Eagle 500kg Bomb`\n");
                case 30 ->stratagems.add("`M-102 Fast Recon Vehicle`\n");
                case 31 ->stratagems.add("`Orbital Precision Strike`\n");
                case 32 ->stratagems.add("`Orbital Gas Strike`\n");
                case 33 ->stratagems.add("`Orbital EMS Strike`\n");
                case 34 ->stratagems.add("`Orbital Smoke Strike`\n");
                case 35 ->stratagems.add("`E/MG-101 HMG Emplacement`\n");
                case 36 ->stratagems.add("`FX-12 Shield Generator Relay`\n");
                case 37 ->stratagems.add("`A/ARC-3 Tesla Tower`\n");
                case 38 ->stratagems.add("`MD-6 Anti-Personnel Minefield`\n");
                case 39 ->stratagems.add("`B-1 Supply Pack`\n");
                case 40 ->stratagems.add("`GL-21 Grenade Launcher`\n");
                case 41 ->stratagems.add("`LAS-98 Laser Cannon`\n");
                case 42 ->stratagems.add("`MD-I4 Incendiary Mines`\n");
                case 43 ->stratagems.add("`AX/LAS-5 Guard Dog Rover`\n");
                case 44 ->stratagems.add("`SH-20 Ballistic Shield Backpack`\n");
                case 45 ->stratagems.add("`ARC-3 Arc Thrower`\n");
                case 46 ->stratagems.add("`MD-17 Anti-Tank Mines`\n");
                case 47 ->stratagems.add("`LAS-99 Quasar Cannon`\n");
                case 48 ->stratagems.add("`SH-32 Shield Generator Pack`\n");
                case 49 ->stratagems.add("`MD-8 Gas Mines`\n");
                case 50 ->stratagems.add("`A/MG-43 Machine Gun Sentry`\n");
                case 51 ->stratagems.add("`A/G-16 Gatling Sentry`\n");
                case 52 ->stratagems.add("`A/M-12 Mortar Sentry`\n");
                case 53 ->stratagems.add("`AX/AR-23 Guard Dog`\n");
                case 54 ->stratagems.add("`A/AC-8 Autocannon Sentry`\n");
                case 55 ->stratagems.add("`A/MLS-4X Rocket Sentry`\n");
                case 56 ->stratagems.add("`A/M-23 EMS Mortar Sentry`\n");
                case 57 ->stratagems.add("`EXO-45 Patriot Exosuit`\n");
                case 58 ->stratagems.add("`EXO-49 Emancipator Exosuit`\n");
                case 59 ->stratagems.add("`TX-41 Sterilizer`\n");
                case 60 ->stratagems.add("`AX/TX-13 Guard Dog Dog Breath`\n");
                case 61 ->stratagems.add("`SH-51 Directional Shield`\n");
                case 62 ->stratagems.add("`E/AT-12 Anti-Tank Emplacement`\n");
                case 63 ->stratagems.add("`A/FLAM-40 Flame Sentry`\n");
            }
        }

        return String.valueOf(stratagems.get(0) + stratagems.get(1) + stratagems.get(2) + stratagems.get(3));
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
    public static String hellpodOpt(){
        String hellpodOpt = "";
        List<Integer> hellpodoptnumbers = new ArrayList<>();
        List<String> hellpodOpts = new ArrayList<>();

        Random hellpodOptran = new Random();
        for (int i = 0; i < 4; i++) {
            int hellpodoptagemInt = hellpodOptran.nextInt(14 -1 + 1) +1;
            if(!hellpodoptnumbers.contains(hellpodoptagemInt)){hellpodoptnumbers.add(hellpodoptagemInt);}
            else i=i-1;
        }
        for (int number : hellpodoptnumbers){
            switch (number) {
                case 1 ->  hellpodOpts.add("Hellpod Space Optimization");
                case 2 ->  hellpodOpts.add("Vitality Enhancement");
                case 3 ->  hellpodOpts.add("UAV Recon Booster");
                case 4 ->  hellpodOpts.add("Stamina Enhancement");
                case 5 ->  hellpodOpts.add("Muscle Enhancement");
                case 6 ->  hellpodOpts.add("Increased Reinforcement Budget");
                case 7 ->  hellpodOpts.add("Flexible Reinforcement Budget");
                case 8 ->  hellpodOpts.add("Localization Confusion Booster");
                case 9 ->  hellpodOpts.add("Expert Extraction Pilot Booster");
                case 10 -> hellpodOpts.add("Motivational Shocks");
                case 11 -> hellpodOpts.add("Experimental Infusion");
                case 12 -> hellpodOpts.add("Firebomb Hellpods");
                case 13 -> hellpodOpts.add("Dead Sprint");
                case 14 -> hellpodOpts.add("Armed Resupply Pods");
            }
        }

        int phrasefranInt = hellpodOptran.nextInt(14 -1 +1) +1;

//        switch (phrasefranInt) {
//            case 1  -> hellpodOpt = "Hellpod Space Optimization";
//            case 2  -> hellpodOpt = "Vitality Enhancement";
//            case 3  -> hellpodOpt = "UAV Recon Booster";
//            case 4  -> hellpodOpt = "Stamina Enhancement";
//            case 5  -> hellpodOpt = "Muscle Enhancement";
//            case 6  -> hellpodOpt = "Increased Reinforcement Budget";
//            case 7  -> hellpodOpt = "Flexible Reinforcement Budget";
//            case 8  -> hellpodOpt = "Localization Confusion Booster";
//            case 9  -> hellpodOpt = "Expert Extraction Pilot Booster";
//            case 10 -> hellpodOpt = "Motivational Shocks";
//            case 11 -> hellpodOpt = "Experimental Infusion";
//            case 12 -> hellpodOpt = "Firebomb Hellpods";
//            case 13 -> hellpodOpt = "Dead Sprint";
//            case 14 -> hellpodOpt = "Armed Resupply Pods";
//        }
        return "1. " + hellpodOpts.get(0) + "\n" +  "2. " + hellpodOpts.get(1) + "\n" + "3. " + hellpodOpts.get(2) + "\n" + "4. " + hellpodOpts.get(3);
        //return hellpodOpt;
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
