package test;

import model.obj.fb.FBAction;
import model.obj.fb.FBActor;

public class Test {

    public static void main(String[] args) {
        FBActor caster = new FBActor();
        caster.setHp(100);
        caster.setAp(10);
        caster.setOffense(10);
        caster.setDefense(10);

        FBActor target = new FBActor();
        target.setHp(100);
        target.setAp(10);
        target.setOffense(10);
        target.setDefense(10);

        FBAction action = new FBAction();
        action.setFormulaPre("caster.hp>=100;caster.ap>=10;");
        action.setFormulaMain("target.hp-=caster.offense-target.defense/2;caster.ap-=1;");
        action.setFormulaPost("caster.hp-=10;");

        System.out.println(caster.getHp());
        System.out.println(caster.getAp());
        System.out.println(target.getHp());

        action.execute(caster, target);

        System.out.println(caster.getHp());
        System.out.println(caster.getAp());
        System.out.println(target.getHp());
    }
}