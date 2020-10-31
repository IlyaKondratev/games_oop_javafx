package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        Figure bishop = new BishopBlack(Cell.C1);
        assertThat(bishop.position(),is(Cell.C1));
    }

    @Test
    public void testWayPosPos() throws ImpossibleMoveException {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] way = bishop.way(Cell.G5);
        assertThat(way, is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test
    public void testWayPosNeg() throws ImpossibleMoveException {
        Figure bishop = new BishopBlack(Cell.D4);
        Cell[] way = bishop.way(Cell.F2);
        assertThat(way, is(new Cell[]{Cell.E3, Cell.F2}));
    }

    @Test
    public void testWayNegPos() throws ImpossibleMoveException {
        Figure bishop = new BishopBlack(Cell.E3);
        Cell[] way = bishop.way(Cell.C5);
        assertThat(way, is(new Cell[]{Cell.D4, Cell.C5}));
    }


    @Test
    public void testWayNegNeg() throws ImpossibleMoveException {
        Figure bishop = new BishopBlack(Cell.G5);
        Cell[] way = bishop.way(Cell.C1);
        assertThat(way, is(new Cell[]{Cell.F4, Cell.E3, Cell.D2, Cell.C1}));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void testWayNotDiagonal() throws ImpossibleMoveException{
        Figure bishop = new BishopBlack(Cell.G5);
        Cell[] way = bishop.way(Cell.F5);
    }

    @Test
    public void testIsDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.G5);
        assertThat(bishop.isDiagonal(Cell.C1, Cell.G5),is(true));
        assertThat(bishop.isDiagonal(Cell.C5, Cell.F2),is(true));
        assertThat(bishop.isDiagonal(Cell.C1, Cell.C2),is(false));
    }

    @Test
    public void testCopy() {
        Figure bishopOld = new BishopBlack(Cell.C1);
        Figure bishopNew = bishopOld.copy(Cell.D2);
        assertThat(bishopNew.position(),is(Cell.D2));
    }
}