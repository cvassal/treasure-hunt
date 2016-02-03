package service;

import domain.adventurer.Adventurer;
import domain.board.element.Case;
import domain.board.element.Treasure;

public class MovementService {
    public static final long ONE_SECONDE = 1000l;
    private final Adventurer adventurer;
    private final DirectionService directionService;

    public MovementService(Adventurer adventurer) {
        this.adventurer = adventurer;
        this.directionService = new DirectionService();
    }

    public void lookAndWalkForward() {
        setNextPosition();
        lookForwardAndGoIfPossible();
        try {
            Thread.currentThread();
            Thread.sleep(ONE_SECONDE);
        } catch (InterruptedException e) {
            //TODO manage this exception like killing thread -> game over for the treasure hunter
            System.out.println(e);
        }
    }

    public void setNextPosition() {
        switch (adventurer.getDirection()) {
            case NORTH:
                adventurer.getNextPosition().goUp();
                break;
            case EAST:
                adventurer.getNextPosition().goRight();
                break;
            case SOUTH:
                adventurer.getNextPosition().goDown();
                break;
            case WEST:
                adventurer.getNextPosition().goLeft();
                break;
        }
    }

    public void lockStartCase() {
        adventurer.getCaseAt(adventurer.getPosition()).lock();
    }

    public void lookForwardAndGoIfPossible() {
        Case caseForward = adventurer.getCaseAt(adventurer.getNextPosition());

        if (caseForward != null && caseForward.isCrossable()) {

            if (caseForward.isUnlock()) {

                if (caseForward.isContainingTreasure()) {
                    adventurer.addToTreasure(((Treasure) caseForward).takeTreasure());
                }

                Case previousCase = adventurer.getCaseAt(adventurer.getPosition());
                previousCase.unlock();
                commitMove();
                caseForward.lock();
                System.out.println(adventurer.toString());
            } else {
                rollBackMove();
                System.out.println(adventurer.getName() + " : " + "I can't go on X : " + adventurer.getNextPosition().getX()
                        + ", Y : " + adventurer.getNextPosition().getY() + " This place is not free");
            }
        } else {
            System.out.println("Can't go at X : " + adventurer.getNextPosition().getX()
                    + ", Y : " + adventurer.getNextPosition().getY());
            rollBackMove();
        }
    }

    private void rollBackMove() {
        adventurer.setNextPosition(adventurer.getPosition());
    }

    public void commitMove() {
        adventurer.setPosition(adventurer.getNextPosition());
    }

    public void goHunt() {
        lockStartCase();
        for (Character movement : adventurer.getMovements()) {
            switch (movement) {
                case 'A':
                    lookAndWalkForward();
                    break;
                case 'G':
                    adventurer.setDirection(directionService.turnLeft(adventurer.getDirection()));
                    break;
                case 'D':
                    adventurer.setDirection(directionService.turnRight(adventurer.getDirection()));
                    break;
            }
        }
    }
}
