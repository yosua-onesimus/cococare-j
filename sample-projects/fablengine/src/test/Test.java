package test;

import model.obj.fb.FbAction;
import model.obj.fb.FbActor;

public class Test {

    public static void main(String[] args) {
        FbActor caster = new FbActor();
        caster.setHp(100);
        caster.setAp(10);
        caster.setOffense(10);
        caster.setDefense(10);

        FbActor target = new FbActor();
        target.setHp(100);
        target.setAp(10);
        target.setOffense(10);
        target.setDefense(10);

        FbAction action = new FbAction();
        action.setFormulaPre("caster.hp>=100;caster.ap>=11;");
//        action.setFormulaMain("target.hp-=caster.offense-target.defense/2;caster.ap-=1;");
        action.setFormulaMain("target.ap-=8;caster.ap+=8");
//        action.setFormulaPost("caster.hp-=10;");

//        System.out.println(caster.getHp());
        System.out.println(caster.getAp());
//        System.out.println(target.getHp());
        System.out.println(target.getAp());

        action.execute(caster, target);

//        System.out.println(caster.getHp());
        System.out.println(caster.getAp());
//        System.out.println(target.getHp());
        System.out.println(target.getAp());
    }
}
/**
 * energy: max 100, digunakan untuk movement, tiap terrain punya movement cost
 * beda2 energy direcover tiap 1 menit sekali action: digunakan untuk examine
 * object, execute skill untuk Priest HP/EP akan digenerate bergantian tiap 1
 * menit sekali untuk Amazer AP/EP akan digenerate bergantian tiap 1 menit
 * sekali untuk knight untuk oracle bisa melakukan capture enemy building tanpa
 * harus destroy, bidding untuk hunter bisa melakukan snipe/missile attack untuk
 * Ranger EP yang digenerate +1
 * 
 * jika dapet item bonus dapat terjadi overfill
 */
/**
 * lethal point: point yang diakibatkan karena menerima damaga
 * max 10, dapat terjadi overfill
 */
/**
 * actor
 * 
 * battleparticipant
 * - actor
 * - ailment/condition
 *   - offense*=2;
 * 
 * absorb, null, weak, normal, strong
 */
/**
 * oracle job yang menyebabkan damage dengan menggunakan prediction
TragicOath: at next 2 turn opponent will get damage 25% of their max hp
JoyousWord: at next 2 turn ally will recover 25% of their hp
BetterOath: at next 3 turn opponent will get damage 50% of their max hp
BetterWord: at next 3 turn ally will recover 50% of their hp
SuperbOath
SuperbWord
SpeechLore
RuneShield

* Cold Bonus	Frozen	beku, hanya bisa psionic, ess berkurang, memperbesar damage bolt, dapat dihilangkan dengan fire
Fire Bonus	Scorch	terbakar, hp berkurang, def berkurang, memperbesar damage aqua, dapat dihilangkan dengan cold
Aqua Bonus	Puffed	sesak nafas, ap berkurang, def berkurang, memperbesar damage fire, dapat dihilangkan dengan bolt
Bolt Bonus	Aghast	terperanjat, hanya bisa physical, off berkurang, memperbesar damage cold, hilang jika terkena aqua
Land	Heavy	a character inflicted with heavy has it's movement speed reduced.
Wind	Dizzy	Attacks both enemies and allies indiscriminately and uncontrollably.

* formula first time: hanya pertama kali terkena
* formula each turn
* formula cancel by damage
* formula cancel by turn
 */
/**
 * 1. copy actor to battle participant
 * 2. each damage decrease actor parameter
 * 3. each action will calculate parameter
 * sample: actor.offense <-- setelah dikurangi dengan break skill 
 * copy battle participant ke action participant
 * get list condition, evaluate satu2
 * 
 * 
 * setiap akhir action sync up hp dan ap
 * 
 * 
 */